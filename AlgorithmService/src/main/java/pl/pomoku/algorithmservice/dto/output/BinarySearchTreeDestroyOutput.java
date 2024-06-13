package pl.pomoku.algorithmservice.dto.output;

import lombok.*;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BinarySearchTreeDestroyOutput extends AbstractCalculationTime<BinarySearchTreeDestroyOutput> {
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
