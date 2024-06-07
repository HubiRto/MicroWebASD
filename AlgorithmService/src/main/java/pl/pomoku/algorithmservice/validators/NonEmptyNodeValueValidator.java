package pl.pomoku.algorithmservice.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.http.HttpStatus;
import pl.pomoku.algorithmservice.algorithm.tree.Node;
import pl.pomoku.algorithmservice.annotations.NonEmptyNodeValue;
import pl.pomoku.algorithmservice.exception.AppException;

public class NonEmptyNodeValueValidator implements ConstraintValidator<NonEmptyNodeValue, Node<Integer>> {
    private String message;

    @Override
    public void initialize(NonEmptyNodeValue constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Node<Integer> node, ConstraintValidatorContext context) {
//        System.out.println(node);
        if(node == null) {
            return true;
        }
        if (node.getData() == null) {
//            System.out.println(node);
            throw new AppException(message, HttpStatus.BAD_REQUEST);
        }

        return isValid(node.getLeft(), context) &&  isValid(node.getRight(), context);
    }
}