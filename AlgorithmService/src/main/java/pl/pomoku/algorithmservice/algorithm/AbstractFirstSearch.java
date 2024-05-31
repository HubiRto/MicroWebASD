package pl.pomoku.algorithmservice.algorithm;

import pl.pomoku.algorithmservice.dto.input.FirstSearchInput;
import pl.pomoku.algorithmservice.dto.output.FirstSearchOutput;
import pl.pomoku.algorithmservice.model.Vertex;
import pl.pomoku.algorithmservice.model.deque.CounterDeque;
import pl.pomoku.algorithmservice.model.deque.CounterLinkedList;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractFirstSearch {
    protected CounterDeque<Vertex<Integer>> deque = new CounterLinkedList<>();
    protected FirstSearchOutput output = new FirstSearchOutput();

    private final Map<Vertex<Integer>, Vertex<Integer>> parentMap = new HashMap<>();
    private List<Vertex<Integer>> vertices;
    private Vertex<Integer> startVertex;

    abstract protected void add(Vertex<Integer> vertex);

    public FirstSearchOutput calculate(FirstSearchInput input) {
        return calculate(input.getGraph(), input.getStartIndex());
    }

    public FirstSearchOutput calculate(int[][] graph, int startVertexIdx) {
        this.vertices = initializeVertices(graph);
        this.startVertex = this.vertices.get(startVertexIdx);

        this.startVertex.visit();
        add(this.startVertex);
        this.parentMap.put(this.startVertex, null);

        while (!this.deque.isEmpty()) {
            Vertex<Integer> current = this.deque.removeFirst();
            this.output.getTraverse().add(current.getData());
            this.output.setMaxDepth(current.getDepth());
            updateCounts(addNeighbors(current));
        }
        generatePaths();
        this.output.addDeque(this.deque);
        return this.output;
    }

    private boolean addNeighbors(Vertex<Integer> current) {
        AtomicBoolean hasUnvisitedNeighbors = new AtomicBoolean(false);
        current.getNeighbors().stream()
                .filter(ngh -> !ngh.isVisited())
                .forEach(ngh -> {
                    add(ngh);
                    ngh.visitAndUpdateDepth(current.getDepth());
                    hasUnvisitedNeighbors.set(true);
                    this.parentMap.put(ngh, current);
                });
        return hasUnvisitedNeighbors.get();
    }

    private void updateCounts(boolean hasUnvisitedNeighbors) {
        if (hasUnvisitedNeighbors) {
            this.output.increaseInternal();
        } else {
            this.output.increaseExternal();
        }
    }

    private void generatePaths() {
        for (Vertex<Integer> vertex : this.vertices) {
            if (vertex != this.startVertex) {
                LinkedList<Integer> path = new LinkedList<>();
                for (Vertex<Integer> at = vertex; at != null; at = this.parentMap.get(at)) {
                    path.addFirst(at.getData());
                }
                if (vertex != null) {
                    this.output.getPaths().put(vertex.getData(), path);
                }
            }
        }
    }

    private List<Vertex<Integer>> initializeVertices(int[][] graph) {
        List<Vertex<Integer>> vertices = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            vertices.add(new Vertex<>(i));
        }

        for (int i = 0; i < graph.length; i++) {
            for (int neighborIdx : graph[i]) {
                vertices.get(i).getNeighbors().add(vertices.get(neighborIdx));
            }
        }

        return vertices;
    }
}
