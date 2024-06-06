package pl.pomoku.algorithmservice.algorithm.tree.traverseConverter;

import pl.pomoku.algorithmservice.algorithm.tree.Node;

public interface TraverseTypeAction {
    Node build(Integer[] array);
    int[] traverse(Node node);
}
