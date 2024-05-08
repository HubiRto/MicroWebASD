package pl.pomoku.algorithmservice.dto.output;

import lombok.*;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepthFirstSearchOutput extends AbstractCalculationTime<DepthFirstSearchOutput> {
    private Map<Integer, List<Integer>> paths;
    private int pushOperationCount;
    private int popOperationCount;
    private int externalCount;
    private int internalCount;
    private int maxDepth;
    private int maxStackSize;
    private List<Integer> traverse;

    @Override
    protected DepthFirstSearchOutput getOutput() {
        return this;
    }
}
