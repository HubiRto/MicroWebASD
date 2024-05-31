package pl.pomoku.algorithmservice.algorithm.stackSequence;

import java.util.Stack;

public enum StackSequenceOperationType implements StackSequenceAction {
    POP {
        @Override
        public Integer execute(Stack<Integer> stack, StackSequenceOperation element, int result) {
            stack.pop();
            return null;
        }
    },
    PUSH {
        @Override
        public Integer execute(Stack<Integer> stack, StackSequenceOperation element, int result) {
            stack.push(element.getValue() != null ? element.getValue() : result);
            return null;
        }
    },
    TOP {
        @Override
        public Integer execute(Stack<Integer> stack, StackSequenceOperation element, int result) {
            return stack.lastElement();
        }
    };
}
