package pl.pomoku.algorithmservice.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.pomoku.algorithmservice.model.HoarePartitionStep;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HoarePartitionOutput {
    private int result;
    private int depth = 0;
    private List<HoarePartitionStep> steps = new ArrayList<>();
    private int partitionCount = 0;

    public void addStep(HoarePartitionStep step) {
        this.steps.add(step);
    }
}
