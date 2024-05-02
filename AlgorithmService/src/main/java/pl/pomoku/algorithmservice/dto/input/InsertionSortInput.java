package pl.pomoku.algorithmservice.dto.input;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.pomoku.algorithmservice.annotations.NotEmptyArray;
import pl.pomoku.algorithmservice.annotations.NotNullArray;
import pl.pomoku.algorithmservice.annotations.SortedArray;
import pl.pomoku.algorithmservice.validators.ValidationOrder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@GroupSequence({
        ValidationOrder.First.class,
        ValidationOrder.Second.class,
        InsertionSortInput.class
})
public class InsertionSortInput {
    @NotNullArray(groups = ValidationOrder.First.class)
    @NotEmptyArray(groups = ValidationOrder.Second.class)
    private int[] arr;
}
