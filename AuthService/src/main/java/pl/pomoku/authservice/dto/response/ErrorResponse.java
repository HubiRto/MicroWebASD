package pl.pomoku.authservice.dto.response;

import java.time.LocalDateTime;

public record ErrorResponse(LocalDateTime timestamp, String message) {
}
