package pl.pomoku.algorithmservice.model.deque;

import lombok.Getter;

import java.util.LinkedList;

@Getter
public class CounterLinkedList<T> extends LinkedList<T> implements CounterDeque<T> {
    private int inOperationCount = 0;
    private int outOperationCount = 0;
    private int maxDequeSize = 0;

    @Override
    public void push(T t) {
        inOperationCount++;
        super.push(t);
        max();
    }

    @Override
    public void addLast(T t) {
        inOperationCount++;
        super.addLast(t);
        max();
    }

    @Override
    public T removeFirst() {
        outOperationCount++;
        return super.removeFirst();
    }

    private void max() {
        if (size() > this.maxDequeSize) {
            this.maxDequeSize = size();
        }
    }

    @Override
    public int maxSize() {
        return this.maxDequeSize;
    }

    @Override
    public int inOperationCount() {
        return this.inOperationCount;
    }

    @Override
    public int outOperationCount() {
        return this.outOperationCount;
    }
}
