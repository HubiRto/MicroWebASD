package pl.pomoku.algorithmservice.dto.output;

import lombok.*;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BinSearchOutput extends AbstractCalculationTime<BinSearchOutput> {
    private List<Integer> mArr;
    private int comparisonsCount;
    private int result;

    @Override
    protected BinSearchOutput getOutput() {
        return this;
    }
}
