package pl.pomoku.algorithmservice.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pl.pomoku.algorithmservice.validators.NotEmptyArrayValidator;
import pl.pomoku.algorithmservice.validators.ValidationOrder;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotEmptyArrayValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmptyArray {
    String message() default "Array cannot be empty";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
