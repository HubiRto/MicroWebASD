package pl.pomoku.algorithmservice.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.pomoku.algorithmservice.algorithm.tree.bst.BinarySearchTreeDestroy;
import pl.pomoku.algorithmservice.dto.input.BinarySearchTreeDestroyInput;
import pl.pomoku.algorithmservice.dto.output.BinarySearchTreeDestroyOutput;

public class BinarySearchTreeDestroyAlgorithmTest {

    @Test
    public void binarySearchTreeDestroyAlgorithmTest1() {
        BinarySearchTreeDestroyInput input = BinarySearchTreeDestroyInput.builder()
                .initArray(new Integer[]{5, 8, 2, 18, 19, 7, 12, 6, 4, 16})
                .removeArray(new Integer[]{8, 18, 19, 12, 2})
                .build();

        BinarySearchTreeDestroyOutput output = BinarySearchTreeDestroy.calculate(input);

        Assertions.assertArrayEquals(new Integer[]{4, 6, 16, 7, 5}, output.getPostOrder());
        Assertions.assertArrayEquals(new Integer[]{4, 5, 6, 7, 16}, output.getInOrder());
        Assertions.assertEquals(2, output.getInternalCount());
    }

    @Test
    public void binarySearchTreeDestroyAlgorithmTest2() {
        BinarySearchTreeDestroyInput input = BinarySearchTreeDestroyInput.builder()
                .initArray(new Integer[]{18,12,13,11,10,6,4,5,2,1})
                .removeArray(new Integer[]{10,1,5,12,4})
                .build();

        BinarySearchTreeDestroyOutput output = BinarySearchTreeDestroy.calculate(input);

        Assertions.assertEquals(3, output.getInternalCount());
        Assertions.assertArrayEquals(new Integer[]{2,6,13,11,18}, output.getPostOrder());
        Assertions.assertEquals(2, output.getExternalCount());
    }
}