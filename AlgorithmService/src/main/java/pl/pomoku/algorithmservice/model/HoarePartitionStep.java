package pl.pomoku.algorithmservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HoarePartitionStep {
    private int[] arr;
    private int index;
}
