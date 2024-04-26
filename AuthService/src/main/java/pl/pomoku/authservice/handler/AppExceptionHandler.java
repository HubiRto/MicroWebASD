package pl.pomoku.authservice.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.pomoku.authservice.dto.response.ErrorResponse;
import pl.pomoku.authservice.exception.AppException;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value = {AppException.class})
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleExceptions(AppException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(new ErrorResponse(ex.getMessage()));
    }
}
