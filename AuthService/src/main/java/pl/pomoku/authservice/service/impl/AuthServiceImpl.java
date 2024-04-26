package pl.pomoku.authservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import pl.pomoku.authservice.dto.request.LoginRequest;
import pl.pomoku.authservice.dto.request.RegisterUserRequest;
import pl.pomoku.authservice.dto.response.LoginResponse;
import pl.pomoku.authservice.entity.Token;
import pl.pomoku.authservice.entity.User;
import pl.pomoku.authservice.exception.AppException;
import pl.pomoku.authservice.repository.TokenRepository;
import pl.pomoku.authservice.service.AuthService;
import pl.pomoku.authservice.service.JwtService;
import pl.pomoku.authservice.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;

    @Override
    public void register(RegisterUserRequest request) {
        userService.create(request);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        var user = userService.getByEmail(request.email());
        var auth = authenticationManager.authenticate(userPassAuthToken(request));
        if(auth.isAuthenticated()){
            String jwtToken = jwtService.generateToken(user);
            String refreshToken = jwtService.generateRefreshToken(user);
            revokeAllUserTokens(user);
            tokenRepository.save(new Token(jwtToken, user));
            return new LoginResponse(jwtToken, refreshToken);
        }else {
            throw new AppException(
                    "Błędny login lub hasło",
                    HttpStatus.FORBIDDEN
            );
        }
    }

    @Override
    public void revokeAllUserTokens(User user) {
        List<Token> validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if(validUserTokens.isEmpty()) return;

        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    @Override
    public LoginResponse refreshToken(String token) {
        User user = userService.getByEmail(jwtService.extractUsername(token));

        if(!jwtService.isTokenValid(token, user)) throw new AppException(
                "Token jest niepoprawny",
                HttpStatus.BAD_REQUEST
        );

        String newToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        tokenRepository.save(new Token(newToken, user));
        return new LoginResponse(newToken, token);
    }

    @Override
    public boolean isTokenValid(String token) {
        Token findToken = tokenRepository.findByToken(token).orElseThrow(() -> new AppException(
           "Nie znaleziono tokena",
           HttpStatus.NOT_FOUND
        ));
        User user = userService.getByEmail(jwtService.extractUsername(token));
        return jwtService.isTokenValid(token, user) && !findToken.isExpired() && !findToken.isRevoked();
    }

    private UsernamePasswordAuthenticationToken userPassAuthToken(LoginRequest request) {
        return new UsernamePasswordAuthenticationToken(
                request.email(),
                request.password()
        );
    }
}
