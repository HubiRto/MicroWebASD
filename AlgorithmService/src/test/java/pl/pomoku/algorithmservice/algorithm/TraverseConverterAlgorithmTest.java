package pl.pomoku.algorithmservice.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static pl.pomoku.algorithmservice.algorithm.tree.traverseConverter.TraverseConverter.convert;
import static pl.pomoku.algorithmservice.algorithm.tree.traverseConverter.TraverseType.*;

public class TraverseConverterAlgorithmTest {

    @Test
    public void traverseConverterResultTest1() {
        Integer[] array = new Integer[]{3, 9, 8, 14, 15, 1, 17};
        assertArrayEquals(convert(array, IN, POST), 3, 8, 9, 15, 17, 1, 14);
        assertArrayEquals(convert(array, IN, PRE), 14, 9, 3, 8, 1, 15, 17);
        assertArrayNotEquals(convert(array, PRE, IN), 17, 9, 14, 3, 1, 15, 8);
    }

    @Test
    public void traverseConverterResultTest2() {
        Integer[] array = new Integer[]{6, 19, 14, 11, 3, 2, 15};
        assertArrayNotEquals(convert(array, PRE, IN), 14, 11, 19, 2, 15, 3, 6);
        assertArrayEquals(convert(array, IN, POST), 6, 14, 19, 3, 15, 2, 11);
        assertArrayNotEquals(convert(array, IN, POST), 11, 19, 6, 14, 2, 3, 15);
    }

    private void assertArrayEquals(int[] actual, int... expected) {
        Assertions.assertArrayEquals(expected, actual);
    }

    private void assertArrayNotEquals(int[] actual, int... expected) {
        Assertions.assertFalse(Arrays.equals(actual, expected));
    }
}
