package pl.pomoku.algorithmservice.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.http.HttpStatus;
import pl.pomoku.algorithmservice.algorithm.tree.Node;
import pl.pomoku.algorithmservice.annotations.UniqueNodeValues;
import pl.pomoku.algorithmservice.exception.AppException;

import java.util.HashSet;
import java.util.Set;

public class UniqueNodeValuesValidator implements ConstraintValidator<UniqueNodeValues, Node> {
    private String message;

    @Override
    public void initialize(UniqueNodeValues constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Node root, ConstraintValidatorContext context) {
        Set<Integer> uniqueValues = new HashSet<>();
        return checkUniqueValues(root, uniqueValues);
    }

    private boolean checkUniqueValues(Node node, Set<Integer> uniqueValues) {
        if (node == null) {
            return true;
        }
        if (!uniqueValues.add(node.getValue())) {
            throw new AppException(message, HttpStatus.BAD_REQUEST);
        }
        return checkUniqueValues(node.getLeft(), uniqueValues) && checkUniqueValues(node.getRight(), uniqueValues);
    }
}