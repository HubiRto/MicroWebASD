package pl.pomoku.algorithmservice.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.pomoku.algorithmservice.dto.output.BinSearchOutput;

import java.util.Arrays;
import java.util.List;

public class BinarySearchAlgorithmTest {

    @Test
    public void binSerachResultTest1() {
        int[] arr = {0, 1, 2, 3, 6, 7, 9, 13, 14, 16, 19};
        BinSearchOutput output = BinSearch.calculate(arr, 0);

        Assertions.assertEquals(output.getComparisonsCount(), 5);
        Assertions.assertFalse(Arrays.equals(output.getMArr().toArray(), Arrays.asList(5, 8, 9, 10).toArray()));
        Assertions.assertEquals(output.getComparisonsCount(), BinSearch.calculate(arr, 3).getComparisonsCount());
    }

    @Test
    public void binSerachResultTest2() {
        int[] arr = {1, 3, 6, 7, 9, 10, 12, 14, 15, 16, 17};
        BinSearchOutput output = BinSearch.calculate(arr, 10);

        Assertions.assertNotEquals(output.getComparisonsCount(), BinSearch.calculate(arr, 16).getComparisonsCount());
        Assertions.assertArrayEquals(output.getMArr().toArray(), List.of(5).toArray());
        Assertions.assertEquals(output.getComparisonsCount(), 1);
    }

    @Test
    public void binSerachResultTest3() {
        int[] arr = {1, 2, 4, 5, 6, 9, 10, 11, 12, 14, 19};
        BinSearchOutput output = BinSearch.calculate(arr, 4);

        Assertions.assertEquals(output.getComparisonsCount(), 3);
        Assertions.assertNotEquals(output.getComparisonsCount(), 0);
        Assertions.assertFalse(Arrays.equals(output.getMArr().toArray(), BinSearch.calculate(arr, 3).getMArr().toArray()));
    }

    @Test
    public void binSerachResultTest4() {
        int[] arr = {0, 1, 2, 3, 5, 6, 9, 10, 11, 15, 18};
        BinSearchOutput output = BinSearch.calculate(arr, 5);

        Assertions.assertArrayEquals(output.getMArr().toArray(), List.of(5, 2, 3, 4).toArray());
        Assertions.assertFalse(Arrays.equals(output.getMArr().toArray(), List.of(5, 2).toArray()));
        Assertions.assertNotEquals(output.getComparisonsCount(), BinSearch.calculate(arr, 0).getComparisonsCount());
    }
}
