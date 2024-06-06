package pl.pomoku.algorithmservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InsertionSortStep {
    private Integer[] arrayState;
    private int comparisons;
    private int swaps;
}
