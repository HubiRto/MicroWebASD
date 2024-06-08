package pl.pomoku.algorithmservice.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import pl.pomoku.algorithmservice.validators.NotEmptyChildMemberOperationValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NotEmptyChildMemberOperationValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmptyChildMemberOperation {
    String message() default "The member must not be empty child.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
