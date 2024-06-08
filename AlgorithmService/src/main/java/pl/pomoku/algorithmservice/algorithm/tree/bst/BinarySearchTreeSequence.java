package pl.pomoku.algorithmservice.algorithm.tree.bst;

import lombok.Getter;
import pl.pomoku.algorithmservice.algorithm.tree.traverseConverter.TraverseType;
import pl.pomoku.algorithmservice.dto.output.BinarySearchTreeSequenceOutput;

import java.util.Arrays;

@Getter
public class BinarySearchTreeSequence {
    private final BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    private int maxTreeHeight, maxTreeElementsSize;

    public BinarySearchTreeSequence(Integer... array) {
        this.tree.insert(array);
        this.maxTreeHeight = this.tree.height();
        this.maxTreeElementsSize = array.length;
    }

    public BinarySearchTreeSequenceOutput calculate(BinarySearchTreeSequenceOperation... operations) {
        Arrays.stream(operations).forEach(this::exec);
        return new BinarySearchTreeSequenceOutput(
                tree.traverse(TraverseType.IN),
                maxTreeElementsSize,
                tree.size(),
                tree.height() - 1,
                maxTreeHeight - 1
        );
    }

    private void exec(BinarySearchTreeSequenceOperation operation) {
        switch (operation.getType()) {
            case DELETE -> {
                if (operation.getChild() != null) {
                    exec(operation.getChild());
                }
                this.tree.delete(operation.getValue());
            }
            case INSERT -> {
                if (operation.getChild() != null) {
                    exec(operation.getChild());
                }
                this.tree.insert(operation.getValue());

                if (this.maxTreeElementsSize < this.tree.size()) {
                    this.maxTreeElementsSize = this.tree.size();
                }

                if (maxTreeHeight < this.tree.height()) {
                    this.maxTreeHeight = this.tree.height();
                }
            }
            case MEMBER -> {
                if (this.tree.contains(operation.getValue())) {
                    exec(operation.getChild());
                }
            }
        }
    }

    public boolean member(int number) {
        return this.tree.contains(number);
    }
}
