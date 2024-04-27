package pl.pomoku.algorithmservice.handler;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.pomoku.algorithmservice.dto.response.ErrorResponse;
import pl.pomoku.algorithmservice.exception.AppException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value = {AppException.class})
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleExceptions(AppException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(new ErrorResponse(
                LocalDateTime.now(),
                ex.getMessage()
        ));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValid(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        Map<String, List<String>> details = new HashMap<>();
        details.put("errors", errors);


        return new ResponseEntity<>(
                    new ErrorResponse(LocalDateTime.now(), "Invalid values", details),
                HttpStatus.BAD_REQUEST
        );
    }
}
