package pl.pomoku.algorithmservice.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pl.pomoku.algorithmservice.validators.NotNullArrayValidator;
import pl.pomoku.algorithmservice.validators.ValidationOrder;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotNullArrayValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNullArray {
    String message() default "Array cannot be null";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
