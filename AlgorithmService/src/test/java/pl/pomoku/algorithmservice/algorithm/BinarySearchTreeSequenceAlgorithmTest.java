package pl.pomoku.algorithmservice.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.pomoku.algorithmservice.algorithm.tree.TreeSequenceOperation;
import pl.pomoku.algorithmservice.algorithm.tree.TreeSequenceOperationType;
import pl.pomoku.algorithmservice.algorithm.tree.bst.BinarySearchTreeSequence;
import pl.pomoku.algorithmservice.dto.output.BinarySearchTreeSequenceOutput;

import static pl.pomoku.algorithmservice.algorithm.tree.TreeSequenceOperationType.*;

public class BinarySearchTreeSequenceAlgorithmTest {

    @Test
    public void binarySearchTreeSequenceAlgorithmTest1() {
        Integer[] array = {3, 11, 15, 9, 13, 12, 8, 17, 6, 7};
        BinarySearchTreeSequenceOutput output = new BinarySearchTreeSequence(array).calculate(
                memberWithInsert(7, 0),
                insert(9, delete(9)),
                insert(15),
                insert(7, delete(16)),
                insert(8, delete(5))
        );

        Assertions.assertEquals(11, output.getTreeElementsSize());
        Assertions.assertEquals(4, output.getCurrentTreeHeight());
        Assertions.assertNotEquals(3, output.getCurrentTreeHeight());
    }

    @Test
    public void binarySearchTreeSequenceAlgorithmTest2() {
        Integer[] array = {8, 18, 4, 9, 17, 16, 15, 19, 3, 5};
        BinarySearchTreeSequenceOutput output = new BinarySearchTreeSequence(array).calculate(
                memberWithDelete(4, 14),
                memberWithDelete(8, 4),
                memberWithDelete(17, 17),
                insert(11),
                insert(13, delete(3))
        );

        Assertions.assertEquals(6, output.getCurrentTreeHeight());
        Assertions.assertNotEquals(7, output.getCurrentTreeHeight());
        Assertions.assertNotEquals(new BinarySearchTreeSequence(array).calculate(
                delete(18),
                insert(19),
                delete(16),
                delete(9, insert(5)),
                delete(10)
        ).getTreeElementsSize(), output.getTreeElementsSize());
    }

    @Test
    public void binarySearchTreeSequenceAlgorithmTest3() {
        Integer[] array = {16, 11, 9, 3, 12, 10, 8, 15, 17, 7};
        BinarySearchTreeSequenceOutput output = new BinarySearchTreeSequence(array).calculate(
                delete(13, insert(3)),
                memberWithInsert(11, 8),
                delete(4, insert(3)),
                memberWithDelete(3, 11),
                delete(5, insert(4))

        );

        Assertions.assertNotEquals(7, output.getCurrentTreeHeight());
        Assertions.assertEquals(6, output.getCurrentTreeHeight());
        Assertions.assertEquals(6, output.getMaxTreeHeight());
    }

    @Test
    public void binarySearchTreeSequenceAlgorithmTest4() {
        BinarySearchTreeSequence bsts = new BinarySearchTreeSequence(17, 3, 13, 16, 2, 12, 10, 15, 8, 14);
        BinarySearchTreeSequenceOutput output = bsts.calculate(
                delete(18),
                memberWithInsert(0, 18),
                delete(19),
                memberWithInsert(7, 6),
                delete(17)
        );

        Assertions.assertEquals(5, output.getMaxTreeHeight());
        Assertions.assertTrue(bsts.member(16));
        Assertions.assertNotEquals(8, output.getTreeElementsSize());
    }

    private TreeSequenceOperation<Integer> memberWithInsert(int member, int insert) {
        return memberWith(member, INSERT, insert);
    }

    private TreeSequenceOperation<Integer> memberWithDelete(int member, int delete) {
        return memberWith(member, DELETE, delete);
    }

    private TreeSequenceOperation<Integer> memberWith(int member, TreeSequenceOperationType type, int number) {
        return new TreeSequenceOperation<>(MEMBER,
                new TreeSequenceOperation<>(type, null, number), member
        );
    }

    private TreeSequenceOperation<Integer> delete(int delete) {
        return new TreeSequenceOperation<>(DELETE, null, delete);
    }

    private TreeSequenceOperation<Integer> delete(int delete, TreeSequenceOperation<Integer> operation) {
        return new TreeSequenceOperation<>(DELETE, operation, delete);
    }

    private TreeSequenceOperation<Integer> insert(int insert) {
        return new TreeSequenceOperation<>(INSERT, null, insert);
    }

    private TreeSequenceOperation<Integer> insert(int insert, TreeSequenceOperation<Integer> operation) {
        return new TreeSequenceOperation<>(INSERT, operation, insert);
    }
}