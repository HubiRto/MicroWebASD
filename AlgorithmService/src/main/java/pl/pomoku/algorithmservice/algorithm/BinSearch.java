package pl.pomoku.algorithmservice.algorithm;

import pl.pomoku.algorithmservice.dto.input.BinSearchInput;
import pl.pomoku.algorithmservice.dto.output.BinSearchOutput;

import java.util.ArrayList;
import java.util.List;

public class BinSearch {
    public static BinSearchOutput calculate(Integer[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        int comparisonsCount = 0;
        List<Integer> mIndices = new ArrayList<>();

        while (left <= right) {
            int mid = left + (right - left) / 2;
            mIndices.add(mid);
            comparisonsCount += 2;
            if (arr[mid] == x) {
                comparisonsCount--;
                return new BinSearchOutput(mIndices, comparisonsCount, mid);
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        comparisonsCount--;
        return new BinSearchOutput(mIndices, comparisonsCount, -1);
    }

    public static BinSearchOutput calculate(BinSearchInput input) {
        return calculate(input.getArr(), input.getX());
    }
}
