package pl.pomoku.algorithmservice.algorithm.stackSequence;

import pl.pomoku.algorithmservice.dto.output.StackSequenceOutput;

import java.util.Arrays;
import java.util.Stack;

public class StackSequence {
    private final Stack<Integer> stack;
    private final StackSequenceOutput output;

    public StackSequence(int... initArray) {
        this.stack = new Stack<>();
        this.output = new StackSequenceOutput();

        for (int value : initArray) {
            stack.push(value);
        }
        output.setMaxSize(stack.size());
    }

    public StackSequenceOutput execute(StackSequenceOperation... elements) {
        Arrays.stream(elements).forEach(this::execute);
        output.setLastSize(stack.size());
        output.setTop(stack.isEmpty() ? -1 : stack.peek());
        return output;
    }

    private int execute(StackSequenceOperation element) {
        element.getType().execute(stack, element, element.getElement() != null ? execute(element.getElement()) : -1);
        checkMax();
        return -1;
    }

    private void checkMax() {
        if (output.getMaxSize() < stack.size()) {
            output.setMaxSize(stack.size());
        }
    }
}
