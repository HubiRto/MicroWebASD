package pl.pomoku.algorithmservice.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.pomoku.algorithmservice.algorithm.tree.TreeSequenceOperation;
import pl.pomoku.algorithmservice.algorithm.tree.TreeSequenceOperationType;
import pl.pomoku.algorithmservice.algorithm.tree.avl.AVLTreeSequence;
import pl.pomoku.algorithmservice.dto.output.AVLTreeSequenceOutput;

import static pl.pomoku.algorithmservice.algorithm.tree.TreeSequenceOperationType.*;

public class AVLTreeSequenceAlgorithmTest {

    @Test
    public void avlTreeSequenceAlgorithmTest1() {
        Integer[] array = {5,2,8,19,0,15,16,6,1,12};
        AVLTreeSequence sequence = new AVLTreeSequence(array);
        AVLTreeSequenceOutput output = sequence.calculate(
                delete(19, insert(15)),
                memberWithInsert(9 ,7),
                insert(5),
                memberWithInsert(7, 15),
                delete(16, insert(19))
        );
        sequence.getTree().print();

        AVLTreeSequence sequence2 = new AVLTreeSequence(array);
        AVLTreeSequenceOutput output2 = sequence2.calculate(
                delete(10, insert(6)),
                delete(7),
                insert(18),
                memberWithInsert(13,5),
                delete(1, insert(17))
        );
        sequence2.getTree().print();

        System.out.println(output.toString());
        System.out.println(output2.toString());

        Assertions.assertEquals(9, output.getTreeElementsSize());
        Assertions.assertNotEquals(4, output.getCurrentTreeHeight());
        Assertions.assertEquals(output.getCurrentTreeHeight(), new AVLTreeSequence(array).calculate(
                delete(10, insert(6)),
                delete(7),
                insert(18),
                memberWithInsert(13,5),
                delete(1, insert(17))
        ).getCurrentTreeHeight());
    }

    private TreeSequenceOperation<Integer> memberWithInsert(int member, int insert) {
        return memberWith(member, INSERT, insert);
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
}