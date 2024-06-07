package pl.pomoku.algorithmservice.algorithm.tree;

import pl.pomoku.algorithmservice.algorithm.tree.traverseConverter.TraverseType;

import java.util.Arrays;

public interface Tree<T extends Comparable<T>> {
    void insert(T data);
    default void insert(T... data) {
         Arrays.stream(data).forEach(this::insert);
    }
    void delete(T data);
    default void delete(T... data) {
        Arrays.stream(data).forEach(this::delete);
    }
    T[] traverse(TraverseType type);
    T getMax();
    T getMin();
    boolean isEmpty();
    int countInternal();
    default int countInternal(Node<T> node) {
        if (node == null || (node.getLeft() == null && node.getRight() == null)) return 0;
        return 1 + countInternal(node.getLeft()) + countInternal(node.getRight());
    }
    int countExternal();
    default int countExternal(Node<T> node) {
        if (node == null) return 0;
        if (node.getLeft() == null && node.getRight() == null) return 1;
        return countExternal(node.getLeft()) + countExternal(node.getRight());
    }
    int height();
    void print();
}
