package pl.pomoku.algorithmservice.algorithm.tree.avl;

import lombok.Getter;
import pl.pomoku.algorithmservice.algorithm.tree.TreeSequence;
import pl.pomoku.algorithmservice.dto.output.AVLTreeSequenceOutput;

@Getter
public class AVLTreeSequence extends TreeSequence<Integer, AVLTreeSequenceOutput> {
    public AVLTreeSequence(Integer... array) {
        super(new AVLTree<>(), new AVLTreeSequenceOutput(), array);
    }
}
