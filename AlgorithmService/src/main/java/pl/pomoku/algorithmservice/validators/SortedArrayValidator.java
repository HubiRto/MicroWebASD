package pl.pomoku.algorithmservice.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.http.HttpStatus;
import pl.pomoku.algorithmservice.annotations.SortedArray;
import pl.pomoku.algorithmservice.exception.AppException;
import pl.pomoku.algorithmservice.utils.ArrayUtils;

public class SortedArrayValidator implements ConstraintValidator<SortedArray, int[]> {
    private String message;
    @Override
    public void initialize(SortedArray constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(int[] array, ConstraintValidatorContext context) {
        if(!ArrayUtils.isSorted(array)){
            throw new AppException(message, HttpStatus.BAD_REQUEST);
        }
        return true;
    }
}
