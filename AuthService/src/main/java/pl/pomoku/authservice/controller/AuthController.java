package pl.pomoku.authservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pomoku.authservice.dto.request.LoginRequest;
import pl.pomoku.authservice.dto.request.RegisterUserRequest;
import pl.pomoku.authservice.dto.response.IsValidResposne;
import pl.pomoku.authservice.service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest request) {
        authService.register(request);
        return ResponseEntity.ok("Created Successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@Param("token") String token) {
        return ResponseEntity.ok(new IsValidResposne(authService.isTokenValid(token)));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@Param("token") String token) {
        return ResponseEntity.ok(authService.refreshToken(token));
    }
}
