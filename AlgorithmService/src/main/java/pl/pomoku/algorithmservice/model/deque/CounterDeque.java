package pl.pomoku.algorithmservice.model.deque;

import java.util.Deque;

public interface CounterDeque<T> extends Deque<T> {
    int maxSize();
    int inOperationCount();
    int outOperationCount();
}
