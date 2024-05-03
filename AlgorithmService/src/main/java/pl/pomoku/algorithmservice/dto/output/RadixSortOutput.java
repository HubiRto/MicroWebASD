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
public class RadixSortOutput extends AbstractCalculationTime<RadixSortOutput> {
    private List<int[]> steps = new ArrayList<>();
    private int maxQueueLength = 0;
    private int firstOperationCount = 0;
    private int outOperationCount = 0;
    private int inOperationCount = 0;

    @Override
    protected RadixSortOutput getOutput() {
        return this;
    }
}
