package pl.pomoku.algorithmservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.pomoku.algorithmservice.dto.response.CalculateResponse;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class AbstractCalculationTime<T> {
    @JsonIgnore
    private long time;
    @JsonIgnore
    protected abstract T getOutput();
    @JsonIgnore
    public CalculateResponse getResponse() {
        return CalculateResponse.builder()
                .timestamp(LocalDateTime.now())
                .calculateTimeMilSec(this.time)
                .data(Map.of("result", getOutput()))
                .build();
    }
}
