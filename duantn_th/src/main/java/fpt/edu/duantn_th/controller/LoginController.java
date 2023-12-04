package fpt.edu.duantn_th.controller;

import fpt.edu.duantn_th.dto.request.LoginRequest;
import fpt.edu.duantn_th.dto.request.MessageResponse;
import fpt.edu.duantn_th.dto.request.RegisterRequest;
import fpt.edu.duantn_th.dto.respon.TokenResponse;
import fpt.edu.duantn_th.entity.Refeshtoken;
import fpt.edu.duantn_th.jwt.JwtService;
import fpt.edu.duantn_th.jwt.UserCustomDetails;
import fpt.edu.duantn_th.service.Impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ban/hang/")
@RequiredArgsConstructor

public class LoginController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtService jwtService;
    @PostMapping("login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(userService.login(loginRequest), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<MessageResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(userService.register(registerRequest), HttpStatus.CREATED);
    }

    // TODO: phương thức có nhiệm vụ cập nhật token.
    @PostMapping("refresh-token")
    public ResponseEntity<TokenResponse> refreshToken(@RequestBody Refeshtoken refreshToken) {
        try {
            // tìm user thông qua token
            TokenResponse response = userService.findByToken(refreshToken.getToken())
                    .map(userService::verifyExpiration) // nếu tìm thấy user sẽ gọi hàm very...
                    .map(Refeshtoken::getUsers) // lấy ra thông tin phật tử
                    .map(phatTu -> {
                        String accessToken = jwtService.generateToken(new UserCustomDetails(phatTu));
                        return TokenResponse.builder()
                                .accessToken(accessToken)
                                .token(refreshToken.getToken())
                                .build();
                    }).orElseThrow(() -> new RuntimeException(
                            "Refresh token is not in database!"));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
