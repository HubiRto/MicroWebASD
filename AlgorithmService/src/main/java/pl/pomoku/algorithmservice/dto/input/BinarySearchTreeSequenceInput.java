package pl.pomoku.algorithmservice.dto.input;

import jakarta.validation.GroupSequence;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pomoku.algorithmservice.algorithm.tree.bst.BinarySearchTreeSequenceOperation;
import pl.pomoku.algorithmservice.annotations.NotEmptyArray;
import pl.pomoku.algorithmservice.annotations.NotEmptyChildMemberOperation;
import pl.pomoku.algorithmservice.annotations.NotNullArray;
import pl.pomoku.algorithmservice.validators.ValidationOrder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@GroupSequence({
        ValidationOrder.First.class,
        ValidationOrder.Second.class,
        ValidationOrder.Third.class,
        BinarySearchTreeSequenceInput.class
})
@Builder
public class BinarySearchTreeSequenceInput {
    @NotNullArray(groups = ValidationOrder.First.class)
    @NotEmptyArray(groups = ValidationOrder.Second.class)
    private Integer[] initArray;
    @NotNullArray(groups = ValidationOrder.First.class)
    @NotEmptyArray(groups = ValidationOrder.Second.class)
    @NotEmptyChildMemberOperation(groups = ValidationOrder.Third.class)
    private BinarySearchTreeSequenceOperation[] operations;
}
