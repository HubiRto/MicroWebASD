package pl.pomoku.algorithmservice.dto.input;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pomoku.algorithmservice.algorithm.tree.traverseConverter.TraverseType;
import pl.pomoku.algorithmservice.annotations.FullBinaryTreeArray;
import pl.pomoku.algorithmservice.annotations.NotEmptyArray;
import pl.pomoku.algorithmservice.annotations.NotNullArray;
import pl.pomoku.algorithmservice.validators.ValidationOrder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@GroupSequence({
        ValidationOrder.First.class,
        ValidationOrder.Second.class,
        ValidationOrder.Third.class,
        TraverseConverterInput.class
})
public class TraverseConverterInput {
    @NotNullArray(groups = ValidationOrder.First.class)
    @NotEmptyArray(groups = ValidationOrder.Second.class)
    @FullBinaryTreeArray(groups = ValidationOrder.Third.class)
    private Integer[] arr;

    @NotNull(groups = ValidationOrder.First.class, message = "Source traversal type must not be null.")
    private TraverseType from;

    @NotNull(groups = ValidationOrder.First.class, message = "Target traversal type must not be null.")
    private TraverseType to;
}
