package pl.pomoku.algorithmservice.algorithm.stackSequence;

import java.util.Stack;

public interface StackSequenceAction {
    Integer execute(Stack<Integer> stack, StackSequenceOperation element, int result);
}
