package pl.pomoku.algorithmservice.algorithm.heap;

import java.util.Arrays;

public class HeapUtils {
    public static <T extends Comparable<T>> MinimumHeap<T> heapSlowConstruct(T[] elements) {
        MinimumHeap<T> heap = new MinimumHeap<>();
        for (T element : elements) {
            heap.insert(element);
        }
        return heap;
    }

    public static <T extends Comparable<T>> MinimumHeap<T> heapFastConstruct(T[] elements) {
        MinimumHeap<T> heap = new MinimumHeap<>();
        heap.heap = Arrays.copyOf(elements, elements.length);
        heap.position = elements.length - 1;

        for (int i = (heap.position - 1) / 2; i >= 0; i--) {
            heap.fixDownward(heap.position);
        }
        return heap;
    }
}
