package pl.pomoku.algorithmservice.dto.input;

import jakarta.validation.GroupSequence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pomoku.algorithmservice.annotations.NotEmptyArray;
import pl.pomoku.algorithmservice.annotations.NotNullArray;
import pl.pomoku.algorithmservice.validators.ValidationOrder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@GroupSequence({
        ValidationOrder.First.class,
        ValidationOrder.Second.class,
        CountingSortInput.class
})
public class CountingSortInput {
    @NotNullArray(groups = ValidationOrder.First.class)
    @NotEmptyArray(groups = ValidationOrder.Second.class)
    private int[] arr;
}
