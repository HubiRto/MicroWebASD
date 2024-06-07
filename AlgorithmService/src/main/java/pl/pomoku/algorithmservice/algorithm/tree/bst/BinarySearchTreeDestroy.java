package pl.pomoku.algorithmservice.algorithm.tree.bst;

import pl.pomoku.algorithmservice.algorithm.tree.Tree;
import pl.pomoku.algorithmservice.algorithm.tree.traverseConverter.TraverseType;
import pl.pomoku.algorithmservice.dto.input.BinarySearchTreeDestroyInput;
import pl.pomoku.algorithmservice.dto.output.BinarySearchTreeDestroyOutput;

public class BinarySearchTreeDestroy {
    public static BinarySearchTreeDestroyOutput calculate(BinarySearchTreeDestroyInput input) {
        Tree<Integer> bst = new BinarySearchTree<>();
        bst.insert(input.getInitArray());
        bst.delete(input.getRemoveArray());
        return new BinarySearchTreeDestroyOutput(
                bst.traverse(TraverseType.PRE),
                bst.traverse(TraverseType.IN),
                bst.traverse(TraverseType.POST),
                bst.countExternal(),
                bst.countInternal(),
                bst.height()
        );
    }
}
