package pl.pomoku.algorithmservice.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.http.HttpStatus;
import pl.pomoku.algorithmservice.algorithm.tree.bst.BinarySearchTreeSequenceOperation;
import pl.pomoku.algorithmservice.annotations.NotEmptyChildMemberOperation;
import pl.pomoku.algorithmservice.exception.AppException;

import static pl.pomoku.algorithmservice.algorithm.tree.bst.BinarySearchTreeSequenceOperationType.MEMBER;

public class NotEmptyChildMemberOperationValidator implements ConstraintValidator<NotEmptyChildMemberOperation, BinarySearchTreeSequenceOperation[]> {
    private String message;

    @Override
    public void initialize(NotEmptyChildMemberOperation constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(BinarySearchTreeSequenceOperation[] operations, ConstraintValidatorContext context) {
        for (BinarySearchTreeSequenceOperation operation : operations) {
            if (operation.getType() == MEMBER && operation.getChild() == null) {
                throw new AppException(message, HttpStatus.BAD_REQUEST);
            }
        }
        return true;
    }
}
