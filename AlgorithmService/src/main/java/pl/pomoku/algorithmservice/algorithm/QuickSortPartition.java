package pl.pomoku.algorithmservice.algorithm;

import pl.pomoku.algorithmservice.dto.input.QuickSortPartitionInput;
import pl.pomoku.algorithmservice.dto.output.QuickSortPartitionOutput;

public class QuickSortPartition {
    static int partition(int[] array, int low, int high, QuickSortPartitionOutput output) {
        output.setPartitionCount(output.getPartitionCount() + 1);
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return (i + 1);
    }

    static void quickSort(int[] array, int low, int high, int currentDepth, boolean isRecursive, QuickSortPartitionOutput output) {
        output.getSteps().add(array.clone());
        if (low < high) {
            if (isRecursive) {
                output.setQuickSortPartitionCount(output.getQuickSortPartitionCount() + 1);
            }
            if (currentDepth > output.getDepth()) {
                output.setDepth(currentDepth);
            }
            int pi = partition(array, low, high, output);
            quickSort(array, low, pi - 1, currentDepth + 1, true, output);
            quickSort(array, pi + 1, high, currentDepth + 1, true, output);
        }
    }

    public static QuickSortPartitionOutput calculate(int[] arr) {
        QuickSortPartitionOutput output = new QuickSortPartitionOutput();
        quickSort(arr, 0, arr.length - 1, 0, false, output);
        return output;
    }

    public static QuickSortPartitionOutput calculate(QuickSortPartitionInput input) {
        return calculate(input.getArr());
    }
}
