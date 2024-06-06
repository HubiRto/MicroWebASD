package pl.pomoku.algorithmservice.utils;

import java.util.Arrays;
import java.util.List;

import static com.mongodb.assertions.Assertions.assertFalse;

public class ArrayUtils {
    public static boolean isSorted(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void assertArrayNotEquals(Integer[] arr1, Integer[] arr2) {
        assertFalse(Arrays.equals(arr1, arr2));
    }

    public static int[] listToArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
