package pl.pomoku.algorithmservice.algorithm;

import pl.pomoku.algorithmservice.model.Vertex;

public class BreadthFirstSearch extends AbstractFirstSearch {
    @Override
    protected void add(Vertex<Integer> vertex) {
        deque.addLast(vertex);
    }
}
