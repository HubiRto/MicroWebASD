package pl.pomoku.algorithmservice.dto.input;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import pl.pomoku.algorithmservice.annotations.NotEmptyArray;
import pl.pomoku.algorithmservice.annotations.NotNullArray;
import pl.pomoku.algorithmservice.annotations.SortedArray;
import pl.pomoku.algorithmservice.validators.ValidationOrder;

@Data
@AllArgsConstructor
@GroupSequence({
        ValidationOrder.First.class,
        ValidationOrder.Second.class,
        ValidationOrder.Third.class,
        BinSearchInput.class
})
public class BinSearchInput {
    @NotNullArray(groups = ValidationOrder.First.class)
    @NotEmptyArray(groups = ValidationOrder.Second.class)
    @SortedArray(groups = ValidationOrder.Third.class)
    private int[] arr;
    @NotNull(
            groups = ValidationOrder.First.class,
            message = "Binary search requires a not-null x value."
    )
    private Integer x;
}
