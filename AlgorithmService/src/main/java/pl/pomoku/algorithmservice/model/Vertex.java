package pl.pomoku.algorithmservice.model;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class Vertex<T> {
    private final T data;
    private boolean visited;
    private int depth = 0;
    @ToString.Exclude
    private List<Vertex<T>> neighbors = new ArrayList<>();

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
