package pl.pomoku.algorithmservice.utils;

import pl.pomoku.algorithmservice.algorithm.tree.Node;

import java.lang.reflect.Array;

public class GenericTraversType<T extends Comparable<T>> {
    public T[] inOrder(Node<T> node) {
        T[] array = createArray(node);
        inOrder(node, array, new int[]{0});
        return array;
    }

    private void inOrder(Node<T> node, T[] array, int[] index) {
        if (node == null) return;
        inOrder(node.getLeft(), array, index);
        array[index[0]++] = node.getData();
        inOrder(node.getRight(), array, index);
    }

    public T[] preOrder(Node<T> node) {
        T[] array = createArray(node);
        preOrder(node, array, new int[]{0});
        return array;
    }

    private void preOrder(Node<T> node, T[] array, int[] index) {
        if (node == null) return;
        array[index[0]++] = node.getData();
        preOrder(node.getLeft(), array, index);
        preOrder(node.getRight(), array, index);
    }

    public T[] postOrder(Node<T> node) {
        T[] array = createArray(node);
        postOrder(node, array, new int[]{0});
        return array;
    }

    private void postOrder(Node<T> node, T[] array, int[] index) {
        if (node == null) return;
        postOrder(node.getLeft(), array, index);
        postOrder(node.getRight(), array, index);
        array[index[0]++] = node.getData();
    }

    private int getSize(Node<T> node) {
        if (node == null) return 0;
        return 1 + getSize(node.getLeft()) + getSize(node.getRight());
    }

    @SuppressWarnings("unchecked cast")
    private T[] createArray(Node<T> node) {
        return (T[]) Array.newInstance(node.getData().getClass(), getSize(node));
    }
}
