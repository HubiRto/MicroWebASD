package pl.pomoku.algorithmservice.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@ToString
public class Vertex<T> {
    private final T data;
    private boolean visited;
    private int depth = 0;
    @ToString.Exclude
    private List<Vertex<T>> neighbors = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return visited == vertex.visited && depth == vertex.depth && Objects.equals(data, vertex.data) && Objects.equals(neighbors, vertex.neighbors);
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    public void visit() {
        this.setVisited(true);
    }

    public void visitAndUpdateDepth(int currentDepth) {
        this.setVisited(true);
        this.setDepth(currentDepth + 1);
    }
}
