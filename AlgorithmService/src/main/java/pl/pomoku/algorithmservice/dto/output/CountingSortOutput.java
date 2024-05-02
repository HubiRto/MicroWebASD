package pl.pomoku.algorithmservice.dto.output;

import lombok.*;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CountingSortOutput extends AbstractCalculationTime<CountingSortOutput> {
    private int[] countArray;
    private int[] sumArray;
    private int[] printArray;

    @Override
    protected CountingSortOutput getOutput() {
        return this;
    }
}
