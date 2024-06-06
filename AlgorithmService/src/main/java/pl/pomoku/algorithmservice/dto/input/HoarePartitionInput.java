package pl.pomoku.algorithmservice.dto.input;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
        HoarePartitionInput.class
})
public class HoarePartitionInput {
    @NotNullArray(groups = ValidationOrder.First.class)
    @NotEmptyArray(groups = ValidationOrder.Second.class)
    private Integer[] arr;
    @NotNull(
            groups = ValidationOrder.Second.class,
            message = "HoarePartition requires a not-null k value."
    )
    @Min(
            value = 0,
            message = "k must be a non-negative integer.",
            groups = ValidationOrder.Second.class
    )
    private Integer k;
}
