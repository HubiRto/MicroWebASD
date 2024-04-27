package pl.pomoku.algorithmservice.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.http.HttpStatus;
import pl.pomoku.algorithmservice.annotations.NotEmptyArray;
import pl.pomoku.algorithmservice.exception.AppException;

public class NotEmptyArrayValidator implements ConstraintValidator<NotEmptyArray, int[]> {
    private String message;
    @Override
    public void initialize(NotEmptyArray constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(int[] array, ConstraintValidatorContext context) {
        if(array.length == 0){
            throw new AppException(message, HttpStatus.BAD_REQUEST);
        }
        return true;
    }
}
