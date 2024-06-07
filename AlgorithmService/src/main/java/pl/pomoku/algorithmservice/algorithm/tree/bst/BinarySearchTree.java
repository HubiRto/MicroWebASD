package pl.pomoku.algorithmservice.algorithm.tree.bst;

import lombok.Getter;
import pl.pomoku.algorithmservice.algorithm.tree.Node;
import pl.pomoku.algorithmservice.algorithm.tree.Tree;
import pl.pomoku.algorithmservice.algorithm.tree.traverseConverter.TraverseType;
import pl.pomoku.algorithmservice.utils.GenericTraversType;

@Getter
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;

    @Override
    public void insert(T data) {
        root = insert(data, root);
    }

    private Node<T> insert(T data, Node<T> node) {
        if (node == null) return new Node<>(data);
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(insert(data, node.getLeft()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(insert(data, node.getRight()));
        }
        return node;
    }

    @Override
    public void delete(T data) {
        root = delete(data, root);
    }

    private Node<T> delete(T data, Node<T> node) {
        if (node == null) return null;
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(delete(data, node.getLeft()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(delete(data, node.getRight()));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            node.setData(getMax(node.getLeft()));
            node.setLeft(delete(node.getData(), node.getLeft()));
        }
        return node;
    }

    @Override
    public T[] traverse(TraverseType type) {
        return switch (type) {
            case IN -> new GenericTraversType<T>().inOrder(root);
            case PRE -> new GenericTraversType<T>().preOrder(root);
            case POST -> new GenericTraversType<T>().postOrder(root);
        };
    }

    @Override
    public T getMax() {
        if (isEmpty()) {
            return null;
        }
        return getMax(root);
    }

    private T getMax(Node<T> node) {
        if (node.getRight() != null) {
            return getMax(node.getRight());
        }
        return node.getData();
    }

    @Override
    public T getMin() {
        if (isEmpty()) {
            return null;
        }
        return getMin(root);
    }

    private T getMin(Node<T> node) {
        if (node.getLeft() != null) {
            return getMin(node.getLeft());
        }
        return node.getData();
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int countInternal() {
        return countInternal(this.root);
    }

    @Override
    public int countExternal() {
        return countExternal(this.root);
    }

    @Override
    public void print() {
        this.root.print();
    }

    @Override
    public int height() {
        return height(this.root);
    }

    private int height(Node<T> node) {
        if (node == null) return 0;
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
