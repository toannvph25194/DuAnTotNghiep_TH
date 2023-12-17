package fpt.edu.duantn_th.service.Impl;

import fpt.edu.duantn_th.dto.request.LoginRequest;
import fpt.edu.duantn_th.dto.request.MessageResponse;
import fpt.edu.duantn_th.dto.request.RegisterRequest;
import fpt.edu.duantn_th.dto.respon.TokenResponse;
import fpt.edu.duantn_th.entity.ChucVu;
import fpt.edu.duantn_th.entity.Refeshtoken;
import fpt.edu.duantn_th.entity.User;
import fpt.edu.duantn_th.jwt.JwtService;
import fpt.edu.duantn_th.jwt.UserCustomDetails;
import fpt.edu.duantn_th.repository.ChucVuRepository;
import fpt.edu.duantn_th.repository.RefreshTokenReponsitory;
import fpt.edu.duantn_th.repository.UserRepository;
import fpt.edu.duantn_th.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ChucVuRepository loaiTaiKhoanRepository;

    private final UserRepository taiKhoanRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final RefreshTokenReponsitory refreshTokenRepository;

    @Override
    public TokenResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getTaikhoan(),
                        loginRequest.getMatkhau()
                )
        );
        // Kiểm tra xem tài khoản đã tồn tại hay không
        Optional<User> optionalPhatTu = taiKhoanRepository.findByTaikhoan(loginRequest.getTaikhoan());
        if (optionalPhatTu.isPresent()) {
            // Tài khoản tồn tại, tạo mới hoặc cập nhật token
            Refeshtoken refreshToken = createToken(loginRequest.getTaikhoan());
            String jwtToken = jwtService.generateToken(new UserCustomDetails(optionalPhatTu.get()));

            return TokenResponse.builder()

                    .accessToken(jwtToken)
                    .token(refreshToken.getToken())
                    .role(optionalPhatTu.get().getChucvu().getTenchucvu().name())
                    .idtk(optionalPhatTu.get().getIdtk())
                    .username(optionalPhatTu.get().getTaikhoan())
                    .message("Login thành công")
                    .build();
        } else {
            return TokenResponse.builder()
                    .message("Sai username hoặc password")
                    .build();
        }
    }

    @Override
    public MessageResponse register(RegisterRequest registerRequest) {
        Optional<User> optionalPhatTu = taiKhoanRepository.findByTaikhoan(registerRequest.getTaikhoan());

        if (optionalPhatTu.isPresent()) {
            return MessageResponse.builder().message("Tài khoản đã tồn tại").build();
        }

        Optional<ChucVu> quyenHan = loaiTaiKhoanRepository.findByTenchucvu(registerRequest.getChucvu());

        if (quyenHan.isEmpty()) {
            return MessageResponse.builder().message("Quyền hạn không hợp lệ").build();
        }

        User user = User.builder()
                .idtk(UUID.randomUUID())
                .taikhoan(registerRequest.getTaikhoan())
                .matkhau(passwordEncoder.encode(registerRequest.getMatkhau()))
                .email(registerRequest.getEmail())
                .chucvu(quyenHan.get())
                .build();

        try {
            User savedUser = taiKhoanRepository.save(user);
            String jwtToken = jwtService.generateToken(new UserCustomDetails(savedUser));
            return MessageResponse.builder().message("Registered Successfully").build();
        } catch (Exception e) {
            return MessageResponse.builder().message("Lỗi trong quá trình đăng ký").build();
        }
    }
    @Override
    public Refeshtoken createToken(String username) {
        Refeshtoken refreshToken = Refeshtoken
                .builder()
                .users(taiKhoanRepository.findByTaikhoan(username).get())
                .token(UUID.randomUUID().toString())
                .thoigianhethan(LocalDate.from(LocalDateTime.now().plusMinutes(10)))
                .build();
        return refreshTokenRepository.save(refreshToken);
    }

    @Override// TODO kiểm tra xem token hết hạn chưa
    public Refeshtoken verifyExpiration(Refeshtoken token) {
        // trả về thời gian hết hạn của token < Thời gian hiện tại tức token hết hạn
        if (token.getThoigianhethan().compareTo(ChronoLocalDate.from(Instant.now())) < 0) {
            refreshTokenRepository.delete(token); // Xóa token
            throw new RuntimeException(token.getToken() +
                    " Refresh token was expired. Please make a new signin request");
        }
        return token;
    }
    @Override
    public Optional<Refeshtoken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }
}
