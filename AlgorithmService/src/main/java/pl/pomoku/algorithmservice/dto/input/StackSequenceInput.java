package pl.pomoku.algorithmservice.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.pomoku.algorithmservice.algorithm.stackSequence.StackSequenceOperation;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StackSequenceInput {
    private StackSequenceOperation[] elements;
}
