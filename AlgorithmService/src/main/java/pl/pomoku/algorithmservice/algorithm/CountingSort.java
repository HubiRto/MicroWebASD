package pl.pomoku.algorithmservice.algorithm;

import pl.pomoku.algorithmservice.dto.input.CountingSortInput;
import pl.pomoku.algorithmservice.dto.output.CountingSortOutput;

public class CountingSort {

    public static CountingSortOutput calculate(CountingSortInput input) {
        return calculate(input.getArr());
    }

    public static CountingSortOutput calculate(Integer[] arr) {
        CountingSortOutput output = new CountingSortOutput();

        int n = arr.length;
        int max = 0;

        for (int j : arr) {
            max = Math.max(max, j);
        }

        int[] tmp = new int[max + 1];

        for (int j : arr) {
            tmp[j]++;
        }

        output.setCountArray(tmp);

        for (int i = 1; i <= max; i++) {
            tmp[i] += tmp[i - 1];
        }

        output.setSumArray(tmp);

        int[] out = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            out[tmp[arr[i]] - 1] = arr[i];
            tmp[arr[i]]--;
        }

        output.setPrintArray(out);
        return output;
    }
}
