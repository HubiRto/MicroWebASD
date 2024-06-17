package pl.pomoku.algorithmservice.algorithm.heap;

public interface IHeap<T extends Comparable<T>> {
    IHeap<T> insert(T data);
    T getRoot();
    T min();
    void delMin();
    int size();
    int getHeight();
}
