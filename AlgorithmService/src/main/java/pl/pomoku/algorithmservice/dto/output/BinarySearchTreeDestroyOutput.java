package pl.pomoku.algorithmservice.dto.output;

import lombok.*;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BinarySearchTreeDestroyOutput extends AbstractCalculationTime<BinarySearchTreeDestroyOutput> implements Serializable {
    private Integer[] preOrder;
    private Integer[] inOrder;
    private Integer[] postOrder;
    private int externalCount;
    private int internalCount;
    private int height;

    @Override
    protected BinarySearchTreeDestroyOutput getOutput() {
        return this;
    }
}
