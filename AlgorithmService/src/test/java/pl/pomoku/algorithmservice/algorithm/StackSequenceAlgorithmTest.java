package pl.pomoku.algorithmservice.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.pomoku.algorithmservice.algorithm.stackSequence.StackSequence;
import pl.pomoku.algorithmservice.algorithm.stackSequence.StackSequenceOperation;
import pl.pomoku.algorithmservice.algorithm.stackSequence.StackSequenceOperationType;
import pl.pomoku.algorithmservice.dto.output.StackSequenceOutput;

import static pl.pomoku.algorithmservice.algorithm.stackSequence.StackSequenceOperationType.*;

public class StackSequenceAlgorithmTest {

    @Test
    public void stackSequenceResultTest1() {
        int[] initArray = new int[]{8, 2, 19, 3, 0, 5, 7, 10, 11, 15, 17, 4};
        StackSequence stackSequence = new StackSequence(initArray);
        StackSequenceOutput output = stackSequence.execute(
                build(POP),
                build(POP, build(PUSH, build(TOP))),
                build(POP),
                build(18),
                build(TOP),
                build(POP)
        );
        Assertions.assertEquals(output.getMaxSize(), 12);
        Assertions.assertNotEquals(output.getMaxSize(), 13);
        Assertions.assertNotEquals(output.getLastSize(), new StackSequence(initArray).execute(
                build(PUSH, build(POP), 13),
                build(PUSH, build(POP), 14),
                build(PUSH, build(TOP)),
                build(TOP),
                build(POP, build(PUSH, build(TOP))),
                build(PUSH, build(TOP))

        ).getLastSize());
    }

    @Test
    public void stackSequenceResultTest2() {
        StackSequence stackSequence = new StackSequence(8, 4, 5, 2, 7, 12, 0, 1, 11, 19, 15, 14);
        StackSequenceOutput output = stackSequence.execute(
                build(POP),
                build(4),
                build(POP, build(4)),
                build(POP),
                build(POP, build(14)),
                build(POP)
        );
        Assertions.assertTrue(output.getTop() > 13);
        Assertions.assertEquals(output.getLastSize(), 10);
        Assertions.assertFalse(output.getTop() < 4);
    }

    @Test
    public void stackSequenceResultTest3() {
        int[] initArray = new int[]{11, 14, 6, 7, 9, 5, 13, 2, 12, 18, 10, 0};
        StackSequence stackSequence = new StackSequence(initArray);
        StackSequenceOutput output = stackSequence.execute(
                build(POP),
                build(0),
                build(POP, build(15)),
                build(POP),
                build(PUSH, build(TOP)),
                build(19)
        );
        Assertions.assertNotEquals(output.getLastSize(), 15);
        Assertions.assertTrue(output.getTop() > new StackSequence(initArray).execute(
                build(PUSH, build(POP), 13),
                build(TOP),
                build(POP),
                build(PUSH, build(TOP)),
                build(TOP),
                build(POP, build(19))
        ).getTop());
        Assertions.assertNotEquals(output.getMaxSize(), 15);
    }

    @Test
    public void stackSequenceResultTest4() {
        StackSequence stackSequence = new StackSequence(10, 17, 3, 8, 9, 6, 7, 0, 5, 2, 13, 4);
        StackSequenceOutput output = stackSequence.execute(
                build(POP, build(PUSH, build(TOP))),
                build(8),
                build(TOP),
                build(POP, build(PUSH, build(TOP))),
                build(POP, build(14)),
                build(POP, build(PUSH, build(TOP)))
        );
        Assertions.assertFalse(output.getTop() > 11);
        Assertions.assertEquals(output.getLastSize(), 13);
        Assertions.assertTrue(output.getTop() < 9);
    }

    @Test
    public void stackSequenceResultTest5() {
        int[] initArray = new int[]{4, 10, 5, 17, 19, 12, 14, 18, 16, 9, 0, 8};
        StackSequence stackSequence = new StackSequence(initArray);
        StackSequenceOutput output = stackSequence.execute(
                build(POP),
                build(TOP),
                build(TOP),
                build(POP, build(13)),
                build(POP),
                build(POP)
        );
        Assertions.assertTrue(output.getTop() < 19);
        Assertions.assertFalse(output.getTop() < 0);
        Assertions.assertFalse(output.getTop() < new StackSequence(initArray).execute(
                build(POP, build(PUSH, build(TOP))),
                build(POP, build(10)),
                build(POP, build(PUSH, build(TOP))),
                build(POP),
                build(POP, build(PUSH, build(TOP))),
                build(PUSH, build(TOP))
        ).getTop());
    }


    private static StackSequenceOperation build(StackSequenceOperationType type) {
        return StackSequenceOperation.builder().type(type).build();
    }


    private static StackSequenceOperation build(StackSequenceOperationType type, StackSequenceOperation element) {
        return StackSequenceOperation.builder().type(type).element(element).build();
    }

    private static StackSequenceOperation build(int value) {
        return StackSequenceOperation.builder().type(StackSequenceOperationType.PUSH).value(value).build();
    }

    private static StackSequenceOperation build(StackSequenceOperationType type, StackSequenceOperation element, int value) {
        return StackSequenceOperation.builder().type(type).element(element).value(value).build();
    }
}
