package pl.pomoku.algorithmservice.algorithm;

import pl.pomoku.algorithmservice.model.Vertex;

public class DepthFirstSearch extends AbstractFirstSearch {
    @Override
    protected void add(Vertex<Integer> vertex) {
        deque.push(vertex);
    }
}
