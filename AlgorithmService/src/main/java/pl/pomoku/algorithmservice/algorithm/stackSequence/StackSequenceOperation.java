package pl.pomoku.algorithmservice.algorithm.stackSequence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StackSequenceOperation {
    private StackSequenceOperationType type;
    private Integer value;
    private StackSequenceOperation element;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StackSequenceOperation that = (StackSequenceOperation) o;
        return type == that.type &&
                Objects.equals(value, that.value) &&
                Objects.equals(element, that.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value, element);
    }
}
