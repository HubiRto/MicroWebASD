package pl.pomoku.algorithmservice.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pl.pomoku.algorithmservice.validators.NonEmptyNodeValueValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NonEmptyNodeValueValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NonEmptyNodeValue {
    String message() default "Node value must not be null or empty";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
