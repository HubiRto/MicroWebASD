package pl.pomoku.algorithmservice.dto.output;

import lombok.*;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StackSequenceOutput extends AbstractCalculationTime<StackSequenceOutput> implements Serializable {
    private int maxSize;
    private int lastSize;
    private int top;
    @Override
    protected StackSequenceOutput getOutput() {
        return this;
    }
}
