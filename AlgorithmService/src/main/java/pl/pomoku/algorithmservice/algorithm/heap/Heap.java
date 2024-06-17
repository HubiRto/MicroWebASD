package pl.pomoku.algorithmservice.algorithm.heap;

import pl.pomoku.algorithmservice.algorithm.huffman.Vertex;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class Heap<T extends Comparable<T>> implements IHeap<T> {

    protected T[] heap;
    protected int position = -1;

    public Heap() {
        heap = (T[]) new Comparable[2];
    }

    protected abstract void fixUpward();

    protected abstract void fixDownward(int endIndex);

    @Override
    public IHeap<T> insert(T data) {
        if (isFull()) {
            resize(2 * heap.length);
        }
        heap[++position] = data;
        fixUpward();
        return this;
    }

    @Override
    public T getRoot() {
        if (isEmpty()) {
            return null;
        }
        T result = heap[0];
        heap[0] = heap[position--];
        heap[position + 1] = null;
        fixDownward(position);
        return result;
    }

    @Override
    public T min() {
        if (isEmpty()) {
            return null;
        }
        return heap[0];
    }

    @Override
    public int size() {
        return position + 1;
    }

    @Override
    public int getHeight() {
        return (int) Math.ceil(Math.log(position + 2) / Math.log(2)) - 1;
    }

    @Override
    public void delMin() {
        if (isEmpty()) {
            return;
        }
        heap[0] = heap[position--];
        heap[position + 1] = null;
        fixDownward(position);
    }

    protected void swap(int firstIndex, int secondIndex) {
        T temp = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = temp;
    }

    private void resize(int capacity) {
        System.arraycopy(heap, 0, heap = (T[]) new Comparable[capacity], 0, position + 1);
    }

    private boolean isFull() {
        return position == heap.length - 1;
    }

    private boolean isEmpty() {
        return position == -1;
    }

    public static List<String> getLeafLabels(Vertex root) {
        List<String> labels = new ArrayList<>();
        getLeafLabelsHelper(root, labels);
        return labels;
    }

    private static void getLeafLabelsHelper(Vertex root, List<String> labels) {
        if (root == null) {
            return;
        }
        if (root.getLeft() != null) {
            getLeafLabelsHelper(root.getLeft(), labels);
        }
        if (root.getRight() != null) {
            getLeafLabelsHelper(root.getRight(), labels);
        }
        if (root.getLeft() == null && root.getRight() == null) {
            labels.add(root.getSymbol());
        }
    }
}