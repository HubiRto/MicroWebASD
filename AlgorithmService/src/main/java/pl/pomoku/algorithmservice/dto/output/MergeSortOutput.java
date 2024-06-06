package pl.pomoku.algorithmservice.dto.output;

import lombok.*;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;
import pl.pomoku.algorithmservice.model.MergeSortStep;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MergeSortOutput extends AbstractCalculationTime<MergeSortOutput> {
    private int recursiveCallCount = 0;
    private int mergeCount = 0;
    private int maxDepth = 0;
    private List<MergeSortStep> steps = new ArrayList<>();
    private Integer[] sortedArray;
    private Integer[] originalArray;

    @Override
    protected MergeSortOutput getOutput() {
        return this;
    }

    public void incrementRecursiveCallCount() {
        recursiveCallCount++;
    }

    public void incrementMergeCount() {
        mergeCount++;
    }
}
