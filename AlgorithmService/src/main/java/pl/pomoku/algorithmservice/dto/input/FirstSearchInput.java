package pl.pomoku.algorithmservice.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FirstSearchInput {
    private Integer[][] graph;
    private int startIndex;
}
