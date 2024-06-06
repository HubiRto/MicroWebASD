package pl.pomoku.algorithmservice.dto.output;

import lombok.*;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class QuickSortPartitionOutput extends AbstractCalculationTime<QuickSortPartitionOutput> {
    private int partitionCount = 0;
    private int quickSortPartitionCount = 0;
    private int depth = 1;
    private List<Integer[]> steps = new ArrayList<>();

    @Override
    protected QuickSortPartitionOutput getOutput() {
        return this;
    }
}
