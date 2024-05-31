package pl.pomoku.algorithmservice.algorithm.stackSequence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StackSequenceOperation {
    private StackSequenceOperationType type;
    private Integer value;
    private StackSequenceOperation element;
}
