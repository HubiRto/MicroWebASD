package pl.pomoku.algorithmservice.algorithm.tree.bst;

import lombok.Getter;
import pl.pomoku.algorithmservice.algorithm.tree.TreeSequence;
import pl.pomoku.algorithmservice.dto.output.BinarySearchTreeSequenceOutput;

@Getter
public class BinarySearchTreeSequence extends TreeSequence<Integer, BinarySearchTreeSequenceOutput> {
    public BinarySearchTreeSequence(Integer... array) {
        super(new BinarySearchTree<>(), new BinarySearchTreeSequenceOutput(), array);
    }
}
