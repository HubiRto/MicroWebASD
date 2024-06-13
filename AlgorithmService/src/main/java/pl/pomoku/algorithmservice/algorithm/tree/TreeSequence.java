package pl.pomoku.algorithmservice.algorithm.tree;

import lombok.Getter;
import pl.pomoku.algorithmservice.algorithm.tree.traverseConverter.TraverseType;
import pl.pomoku.algorithmservice.dto.output.TreeSequenceOutput;

import java.util.Arrays;

@Getter
public class TreeSequence<E extends Comparable<E>, O extends TreeSequenceOutput<E>> {
    private final Tree<E> tree;
    private final O output;
    private int maxTreeHeight, maxTreeElementsSize;

    @SafeVarargs
    public TreeSequence(Tree<E> tree, O output, E... array) {
        this.tree = tree;
        this.tree.insert(array);
        this.output = output;
        this.maxTreeHeight = this.tree.height();
        this.maxTreeElementsSize = array.length;
    }

    @SafeVarargs
    public final O calculate(TreeSequenceOperation<E>... operations) {
        Arrays.stream(operations).forEach(this::exec);
        this.output.setTreeElements(tree.traverse(TraverseType.IN));
        this.output.setMaxTreeElementsSize(maxTreeElementsSize);
        this.output.setTreeElementsSize(tree.size());
        this.output.setMaxTreeHeight(maxTreeHeight - 1);
        this.output.setCurrentTreeHeight(tree.height() - 1);
        return output;
    }

    private void exec(TreeSequenceOperation<E> operation) {
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

    public boolean member(E element) {
        return this.tree.contains(element);
    }
}
