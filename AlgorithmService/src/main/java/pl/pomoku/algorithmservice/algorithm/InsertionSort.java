package pl.pomoku.algorithmservice.algorithm;

import pl.pomoku.algorithmservice.dto.input.InsertionSortInput;
import pl.pomoku.algorithmservice.dto.output.InsertionSortOutput;
import pl.pomoku.algorithmservice.model.InsertionSortStep;
import pl.pomoku.algorithmservice.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {

    public static InsertionSortOutput calculate(InsertionSortInput input) {
        return calculate(input.getArr());
    }

    public static InsertionSortOutput calculate(Integer[] arr) {
        List<InsertionSortStep> steps = new ArrayList<>();
        int comparisons = 0;
        int swaps = 0;

        int i, j;

        for (i = 1; i < arr.length; i++) {
            j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                ArrayUtils.swap(arr, j - 1, j);
                j--;
                comparisons++;
                swaps++;
            }

            if(j > 0) comparisons++;

            steps.add(new InsertionSortStep(arr.clone(), comparisons, swaps));
        }
        return new InsertionSortOutput(steps);
    }
}
