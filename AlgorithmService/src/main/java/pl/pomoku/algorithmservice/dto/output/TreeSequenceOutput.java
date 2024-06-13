package pl.pomoku.algorithmservice.dto.output;

import lombok.*;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TreeSequenceOutput<T> extends AbstractCalculationTime<TreeSequenceOutput<T>> {
    private T[] treeElements;
    private int maxTreeElementsSize;
    private int treeElementsSize;
    private int currentTreeHeight;
    private int maxTreeHeight;

    @Override
    protected TreeSequenceOutput<T> getOutput() {
        return this;
    }
}
