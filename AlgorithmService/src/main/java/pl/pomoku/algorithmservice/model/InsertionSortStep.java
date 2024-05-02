package pl.pomoku.algorithmservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InsertionSortStep {
    int[] arrayState;
    int comparisons;
    int swaps;
}
