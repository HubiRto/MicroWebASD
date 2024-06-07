package pl.pomoku.algorithmservice.algorithm.tree.traverseConverter;

import pl.pomoku.algorithmservice.algorithm.tree.Node;

public interface TraverseTypeAction<T extends Comparable<T>> {
    Node<T> build(Integer[] array);

    T[] traverse(Node<T> node);
}
