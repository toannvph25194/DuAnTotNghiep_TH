package fpt.edu.duantn_th.service;

import fpt.edu.duantn_th.dto.request.LoginRequest;
import fpt.edu.duantn_th.dto.request.MessageResponse;
import fpt.edu.duantn_th.dto.request.RegisterRequest;
import fpt.edu.duantn_th.dto.respon.TokenResponse;
import fpt.edu.duantn_th.entity.Refeshtoken;
import fpt.edu.duantn_th.repository.RefreshTokenReponsitory;

import java.util.Optional;

public interface UserService {
    TokenResponse login(LoginRequest loginRequest);

    MessageResponse register(RegisterRequest registerRequest);

    Refeshtoken createToken(String username);

    Refeshtoken verifyExpiration(Refeshtoken token);

    Optional<Refeshtoken> findByToken(String token);
}
