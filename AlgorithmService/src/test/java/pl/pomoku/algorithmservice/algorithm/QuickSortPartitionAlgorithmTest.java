package pl.pomoku.algorithmservice.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.pomoku.algorithmservice.dto.output.QuickSortPartitionOutput;

import static pl.pomoku.algorithmservice.algorithm.QuickSortPartition.calculate;

public class QuickSortPartitionAlgorithmTest {

    @Test
    public void quickSortPartitionResult1() {
        int[] arr = {18, 16, 10, 13, 15, 12, 9, 6, 19, 4, 7};
        QuickSortPartitionOutput output = calculate(arr);

        Assertions.assertEquals(output.getPartitionCount(), 6);
        Assertions.assertEquals(output.getQuickSortPartitionCount(), 5);
        Assertions.assertNotEquals(
                output.getPartitionCount(),
                calculate(new int[]{16, 12, 15, 10, 18, 9, 19, 4, 7, 13, 6}).getPartitionCount()
        );
    }

    @Test
    public void quickSortPartitionResult2() {
        int[] arr = {11, 17, 9, 4, 12, 1, 7, 18, 0, 14, 2};
        QuickSortPartitionOutput output = calculate(arr);

        Assertions.assertEquals(output.getPartitionCount(), 8);
        Assertions.assertEquals(
                output.getQuickSortPartitionCount(),
                calculate(new int[]{18, 12, 14, 0, 9, 11, 7, 1, 17, 2, 4}).getQuickSortPartitionCount()
        );
        Assertions.assertNotEquals(
                output.getQuickSortPartitionCount(),
                calculate(new int[]{2, 11, 7, 17, 18, 9, 14, 12, 4, 0, 1}).getQuickSortPartitionCount()
        );
    }

    @Test
    public void quickSortPartitionResult3() {
        int[] arr = {12, 3, 16, 11, 15, 1, 18, 17, 9, 6, 2};
        QuickSortPartitionOutput output = calculate(arr);

        Assertions.assertEquals(output.getDepth(), 5);
        Assertions.assertNotEquals(
                output.getPartitionCount(),
                calculate(new int[]{15, 6, 12, 1, 17, 3, 9, 18, 2, 11, 16}).getPartitionCount()
        );
        Assertions.assertNotEquals(output.getPartitionCount(), 5);
    }

    @Test
    public void quickSortPartitionResult4() {
        int[] arr = {11, 19, 4, 7, 18, 9, 0, 17, 15, 3, 13};
        QuickSortPartitionOutput output = calculate(arr);

        Assertions.assertEquals(output.getDepth(), 4);
        Assertions.assertEquals(
                output.getPartitionCount(),
                calculate(new int[]{4, 9, 18, 0, 15, 7, 13, 17, 11, 3, 19}).getPartitionCount()
        );
        Assertions.assertNotEquals(output.getQuickSortPartitionCount(), 5);
    }

    @Test
    public void quickSortPartitionResult5() {
        int[] arr = {13, 10, 18, 8, 9, 17, 4, 12, 3, 16, 19};
        QuickSortPartitionOutput output = calculate(arr);
        Assertions.assertEquals(
                output.getQuickSortPartitionCount(),
                calculate(new int[]{19, 18, 4, 13, 10, 8, 9, 16, 17, 3, 12}).getQuickSortPartitionCount()
        );
        Assertions.assertEquals(output.getPartitionCount(), 9);
        Assertions.assertArrayEquals(
                output.getSteps().get(0),
                new int[]{13, 10, 18, 8, 9, 17, 4, 12, 3, 16, 19}
        );
    }
}
