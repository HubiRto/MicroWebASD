package pl.pomoku.algorithmservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pomoku.algorithmservice.dto.input.FirstSearchInput;
import pl.pomoku.algorithmservice.dto.output.FirstSearchOutput;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class FirstSearchEntity {
    private int hash;
    private FirstSearchInput input;
    private FirstSearchOutput output;
}

