package pl.pomoku.apigateway.dto.response;

import java.time.LocalDateTime;

public record ErrorResponse(String message, LocalDateTime timestamp) {
}
