package pl.pomoku.algorithmservice.algorithm.tree.bst;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class BinarySearchTreeSequenceOperation {
    private BinarySearchTreeSequenceOperationType type;
    private Integer value;
    private BinarySearchTreeSequenceOperation child;
}
