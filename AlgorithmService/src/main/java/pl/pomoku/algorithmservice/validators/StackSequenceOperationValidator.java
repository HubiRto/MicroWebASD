package pl.pomoku.algorithmservice.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.http.HttpStatus;
import pl.pomoku.algorithmservice.algorithm.stackSequence.StackSequenceOperation;
import pl.pomoku.algorithmservice.annotations.ValidStackSequenceOperation;
import pl.pomoku.algorithmservice.exception.AppException;

import java.util.Stack;

public class StackSequenceOperationValidator implements ConstraintValidator<ValidStackSequenceOperation, StackSequenceOperation[]> {
    @Override
    public void initialize(ValidStackSequenceOperation constraintAnnotation) {
    }

    @Override
    public boolean isValid(StackSequenceOperation[] value, ConstraintValidatorContext context) {
        if (value == null) return true;

        Stack<Integer> stack = new Stack<>();
        for (StackSequenceOperation operation : value) {
            validateOperation(operation, stack);
        }

        return true;
    }

    private Integer validateOperation(StackSequenceOperation operation, Stack<Integer> stack) {
        if (operation == null) {
            throw new AppException("Operation must not be null", HttpStatus.BAD_REQUEST);
        }

        if (operation.getType() == null) {
            throw new AppException("Operation type must not be null", HttpStatus.BAD_REQUEST);
        }

        Integer result = null;
        switch (operation.getType()) {
            case PUSH:
                if (operation.getValue() != null) {
                    stack.push(operation.getValue());
                } else if (operation.getElement() != null) {
                    result = validateOperation(operation.getElement(), stack);
                    stack.push(result);
                } else {
                    throw new AppException("PUSH operation must have a value or a nested operation", HttpStatus.BAD_REQUEST);
                }
                break;
            case POP:
                if (stack.isEmpty()) {
                    throw new AppException("Cannot perform POP on an empty stack", HttpStatus.BAD_REQUEST);
                }
                stack.pop();
                break;
            case TOP:
                if (stack.isEmpty()) {
                    throw new AppException("Cannot perform TOP on an empty stack", HttpStatus.BAD_REQUEST);
                }
                result = stack.peek();
                break;
            default:
                throw new AppException("Unsupported operation type", HttpStatus.BAD_REQUEST);
        }

        return result;
    }
}
