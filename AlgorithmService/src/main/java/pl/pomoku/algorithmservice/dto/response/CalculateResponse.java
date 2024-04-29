package pl.pomoku.algorithmservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CalculateResponse {
    private LocalDateTime timestamp;
    private long calculateTimeMilSec;
    private Map<?,?> data;
}
