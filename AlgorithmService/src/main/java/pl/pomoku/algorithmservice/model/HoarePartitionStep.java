package pl.pomoku.algorithmservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HoarePartitionStep {
    private Integer[] arr;
    private int index;
}
