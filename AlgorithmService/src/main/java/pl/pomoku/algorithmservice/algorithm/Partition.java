package pl.pomoku.algorithmservice.algorithm;

import pl.pomoku.algorithmservice.dto.input.PartitionInput;
import pl.pomoku.algorithmservice.dto.output.PartitionOutput;
import pl.pomoku.algorithmservice.model.PartitionState;
import pl.pomoku.algorithmservice.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition {
    public static PartitionOutput calculateWithOutput(Integer[] arr) {
        List<PartitionState> states = new ArrayList<>();
        int comparisonsCount = 0;

        int l = -1, r = 0, n = arr.length;

        while (r < n - 1) {
            comparisonsCount++;
            if (arr[r] < arr[n - 1]) {
                if (r > l + 1) {
                    ArrayUtils.swap(arr, r, l + 1);
                    states.add(new PartitionState(Arrays.copyOf(arr, arr.length), l + 1, r + 1, comparisonsCount));
                }
                l++;
            }
            r++;
        }
        if ((l + 1) < (n - 1)) {
            ArrayUtils.swap(arr, l + 1, n - 1);
            states.add(new PartitionState(Arrays.copyOf(arr, arr.length), l + 1, r + 1, comparisonsCount));
        }
        return new PartitionOutput(l + 1, states);
    }

    public static PartitionOutput calculateWithOutput(PartitionInput input) {
        return calculateWithOutput(input.getArr());
    }

    public static int calculate(Integer[] arr) {
        int l = -1, r = 0, n = arr.length;

        while (r < n - 1) {
            if (arr[r] < arr[n - 1]) {
                if (r > l + 1) {
                    ArrayUtils.swap(arr, r, l + 1);
                }
                l++;
            }
            r++;
        }
        if ((l + 1) < (n - 1)) {
            ArrayUtils.swap(arr, l + 1, n - 1);
        }
        return l + 1;
    }
}
