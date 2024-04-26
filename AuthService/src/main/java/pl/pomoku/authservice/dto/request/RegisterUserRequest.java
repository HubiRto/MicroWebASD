package pl.pomoku.authservice.dto.request;

public record RegisterUserRequest(String email, String studentId, String password) {
}
