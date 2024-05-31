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
public class BinSearchOutput extends AbstractCalculationTime<BinSearchOutput> implements Serializable {
    private List<Integer> mArr;
    private int comparisonsCount;
    private int result;

    @Override
    protected BinSearchOutput getOutput() {
        return this;
    }
}
