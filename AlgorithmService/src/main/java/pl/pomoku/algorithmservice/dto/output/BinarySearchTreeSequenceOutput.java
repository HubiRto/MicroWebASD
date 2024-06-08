package pl.pomoku.algorithmservice.dto.output;

import lombok.*;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BinarySearchTreeSequenceOutput extends AbstractCalculationTime<BinarySearchTreeSequenceOutput> implements Serializable {
    private Integer[] treeElements;
    private int maxTreeElementsSize;
    private int treeElementsSize;
    private int currentTreeHeight;
    private int maxTreeHeight;

    @Override
    protected BinarySearchTreeSequenceOutput getOutput() {
        return this;
    }
}
