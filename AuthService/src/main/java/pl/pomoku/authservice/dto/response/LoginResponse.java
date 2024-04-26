package pl.pomoku.authservice.dto.response;

public record LoginResponse(String token, String refreshToken) {
}
