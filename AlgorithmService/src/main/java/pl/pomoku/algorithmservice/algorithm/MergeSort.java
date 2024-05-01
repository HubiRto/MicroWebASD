package pl.pomoku.algorithmservice.algorithm;

import pl.pomoku.algorithmservice.dto.input.MergeSortInput;
import pl.pomoku.algorithmservice.dto.output.MergeSortOutput;
import pl.pomoku.algorithmservice.model.MergeSortStep;

public class MergeSort {

    public static MergeSortOutput calculate(MergeSortInput input) {
        return calculate(input.getArr());
    }

    public static MergeSortOutput calculate(int[] arr) {
        MergeSortOutput data = new MergeSortOutput();
        data.setOriginalArray(arr.clone());
        mergeSort(arr, -1, data);
        data.setSortedArray(arr);
        return data;
    }

    private static void mergeSort(int[] arr, int depth, MergeSortOutput data) {
        if (arr.length > 1) {
            if (depth + 1 > data.getMaxDepth()) {
                data.setMaxDepth(depth + 1);
            }

            data.getSteps().add(new MergeSortStep(data.getRecursiveCallCount() + 1, arr));

            int mid = arr.length / 2;
            int[] leftHalf = new int[mid];
            int[] rightHalf = new int[arr.length - mid];

            System.arraycopy(arr, 0, leftHalf, 0, mid);
            System.arraycopy(arr, mid, rightHalf, 0, arr.length - mid);

            if (leftHalf.length > 1) {
                data.incrementRecursiveCallCount();
                mergeSort(leftHalf, depth + 1, data);
            }
            if (rightHalf.length > 1) {
                data.incrementRecursiveCallCount();
                mergeSort(rightHalf, depth + 1, data);
            }

            data.incrementMergeCount();
            merge(arr, leftHalf, rightHalf);
        }
    }

    private static void merge(int[] arr, int[] leftHalf, int[] rightHalf) {
        int i = 0, j = 0, k = 0;

        while (i < leftHalf.length && j < rightHalf.length) {
            arr[k++] = leftHalf[i] <= rightHalf[j] ? leftHalf[i++] : rightHalf[j++];
        }
        while (i < leftHalf.length) {
            arr[k++] = leftHalf[i++];
        }
        while (j < rightHalf.length) {
            arr[k++] = rightHalf[j++];
        }
    }
}
