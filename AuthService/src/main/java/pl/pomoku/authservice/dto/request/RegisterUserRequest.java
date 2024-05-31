package pl.pomoku.authservice.dto.request;

public record RegisterUserRequest(String email, String firstName, String lastName, String password) {
}
