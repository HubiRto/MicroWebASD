package pl.pomoku.authservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import pl.pomoku.authservice.dto.request.LoginRequest;
import pl.pomoku.authservice.dto.request.RegisterUserRequest;
import pl.pomoku.authservice.dto.response.IsValidResposne;
import pl.pomoku.authservice.exception.AppException;
import pl.pomoku.authservice.repository.UserRepository;
import pl.pomoku.authservice.service.JwtService;
import pl.pomoku.authservice.service.UserService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest request) {
        userService.create(request);
        return ResponseEntity.ok("Created Successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        var userDetails = userDetailsService.loadUserByUsername(request.email());
        var auth = authenticationManager.authenticate(userPassAuthToken(request));
        if(auth.isAuthenticated()){
            return ResponseEntity.ok(jwtService.generateToken(userDetails));
        }else {
            throw new AppException(
                    "Błędny login lub hasło",
                    HttpStatus.FORBIDDEN
            );
        }
    }

    @GetMapping("/validate")
    public ResponseEntity<IsValidResposne> validateToken(@Param("token") String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtService.extractUsername(token));
        return ResponseEntity.ok(new IsValidResposne(jwtService.isTokenValid(token, userDetails)));
    }

    private UsernamePasswordAuthenticationToken userPassAuthToken(LoginRequest request) {
        return new UsernamePasswordAuthenticationToken(request.email(), request.password());
    }
}
