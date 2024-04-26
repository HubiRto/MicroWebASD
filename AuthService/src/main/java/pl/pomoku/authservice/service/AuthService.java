package pl.pomoku.authservice.service;

import pl.pomoku.authservice.dto.request.LoginRequest;
import pl.pomoku.authservice.dto.request.RegisterUserRequest;
import pl.pomoku.authservice.dto.response.LoginResponse;
import pl.pomoku.authservice.entity.User;

public interface AuthService {
    void register(RegisterUserRequest request);
    LoginResponse login(LoginRequest request);
    void revokeAllUserTokens(User user);
    LoginResponse refreshToken(String token);
    boolean isTokenValid(String token);
}
