package pl.pomoku.algorithmservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MergeSortStep {
    private int argIndex;
    private int[] arr;
}
