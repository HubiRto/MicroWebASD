package pl.pomoku.algorithmservice.dto.input;

import jakarta.validation.GroupSequence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pomoku.algorithmservice.algorithm.tree.Node;
import pl.pomoku.algorithmservice.annotations.NonEmptyNodeValue;
import pl.pomoku.algorithmservice.annotations.UniqueNodeValues;
import pl.pomoku.algorithmservice.validators.ValidationOrder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@GroupSequence({
        ValidationOrder.First.class,
        ValidationOrder.Second.class,
        TreeCheckerInput.class
})
public class TreeCheckerInput {
    @NonEmptyNodeValue(groups = ValidationOrder.First.class)
    @UniqueNodeValues(groups = ValidationOrder.Second.class)
    private Node tree;
}
