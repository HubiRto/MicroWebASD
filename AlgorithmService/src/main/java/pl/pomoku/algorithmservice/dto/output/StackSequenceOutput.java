package pl.pomoku.algorithmservice.dto.output;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;

import java.io.Serializable;
import java.util.List;

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
