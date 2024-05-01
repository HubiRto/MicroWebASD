package pl.pomoku.algorithmservice.dto.output;

import lombok.*;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;
import pl.pomoku.algorithmservice.model.HoarePartitionStep;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HoarePartitionOutput extends AbstractCalculationTime<HoarePartitionOutput> {
    private int result;
    private int depth = 0;
    private List<HoarePartitionStep> steps = new ArrayList<>();
    private int partitionCount = 0;

    public void addStep(HoarePartitionStep step) {
        this.steps.add(step);
    }

    @Override
    protected HoarePartitionOutput getOutput() {
        return this;
    }
}
