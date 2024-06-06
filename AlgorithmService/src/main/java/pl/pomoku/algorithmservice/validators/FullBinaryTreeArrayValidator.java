package pl.pomoku.algorithmservice.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.http.HttpStatus;
import pl.pomoku.algorithmservice.annotations.FullBinaryTreeArray;
import pl.pomoku.algorithmservice.exception.AppException;

public class FullBinaryTreeArrayValidator implements ConstraintValidator<FullBinaryTreeArray, Integer[]> {
    private String message;

    @Override
    public void initialize(FullBinaryTreeArray constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Integer[] array, ConstraintValidatorContext context) {
        int length = array.length;
        if (length == 0 || (length & (length + 1)) != 0) {
            throw new AppException(message, HttpStatus.BAD_REQUEST);
        }
        return true;
    }
}
