package pl.pomoku.algorithmservice.algorithm.tree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TreeSequenceOperation<T> {
    private TreeSequenceOperationType type;
    private TreeSequenceOperation<T> child;
    private T value;
}
