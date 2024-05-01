package pl.pomoku.algorithmservice.dto.output;

import lombok.*;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;
import pl.pomoku.algorithmservice.model.PartitionState;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PartitionOutput extends AbstractCalculationTime<PartitionOutput> {
    private int result;
    private List<PartitionState> states;

    @Override
    protected PartitionOutput getOutput() {
        return this;
    }
}
