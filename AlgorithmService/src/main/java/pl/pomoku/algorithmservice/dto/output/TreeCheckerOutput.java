package pl.pomoku.algorithmservice.dto.output;

import lombok.*;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;
import pl.pomoku.algorithmservice.model.TreeCheckerStep;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TreeCheckerOutput extends AbstractCalculationTime<TreeCheckerOutput> implements Serializable {
    private List<TreeCheckerStep> steps = new ArrayList<>();
    private int internalEdges = 0;
    private int externalEdges = 0;
    private int height = 0;

    @Override
    protected TreeCheckerOutput getOutput() {
        return this;
    }
}
