package pl.pomoku.algorithmservice.dto.output;

import lombok.*;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;
import pl.pomoku.algorithmservice.model.InsertionSortStep;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class InsertionSortOutput extends AbstractCalculationTime<InsertionSortOutput> {
    private List<InsertionSortStep> steps = new ArrayList<>();

    @Override
    protected InsertionSortOutput getOutput() {
        return this;
    }
}
