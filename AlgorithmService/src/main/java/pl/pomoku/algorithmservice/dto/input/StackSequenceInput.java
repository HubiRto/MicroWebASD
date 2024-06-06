package pl.pomoku.algorithmservice.dto.input;

import jakarta.validation.GroupSequence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.pomoku.algorithmservice.algorithm.stackSequence.StackSequenceOperation;
import pl.pomoku.algorithmservice.annotations.NotEmptyArray;
import pl.pomoku.algorithmservice.annotations.NotNullArray;
import pl.pomoku.algorithmservice.annotations.ValidStackSequenceOperation;
import pl.pomoku.algorithmservice.validators.ValidationOrder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@GroupSequence({ValidationOrder.First.class, ValidationOrder.Second.class, StackSequenceInput.class})
public class StackSequenceInput {
    @NotNullArray(groups = ValidationOrder.First.class)
    @NotEmptyArray(groups = ValidationOrder.Second.class)
    private Integer[] initArray;

    @NotNullArray(groups = ValidationOrder.First.class)
    @NotEmptyArray(groups = ValidationOrder.Second.class)
    @ValidStackSequenceOperation(groups = ValidationOrder.Second.class)
    private StackSequenceOperation[] elements;
}
