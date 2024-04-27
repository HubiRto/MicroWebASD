package pl.pomoku.algorithmservice.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pl.pomoku.algorithmservice.validators.SortedArrayValidator;
import pl.pomoku.algorithmservice.validators.ValidationOrder;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SortedArrayValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface SortedArray {
    String message() default "Array must be sorted";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
