package pl.pomoku.algorithmservice.dto.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TraverseConverterOutput extends AbstractCalculationTime<TraverseConverterOutput> {
    private Integer[] result;

    @Override
    protected TraverseConverterOutput getOutput() {
        return this;
    }
}
