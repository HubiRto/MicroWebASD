package pl.pomoku.algorithmservice.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Vertex<T> {
    private final T data;
    private boolean visited;
    private List<Vertex<T>> neighbors = new ArrayList<>();

    @Override
    public String toString() {
        return "Vertex(" + data + " : " + visited + "): " + Arrays.toString(neighborsToString()) + "\n";
    }

    public String[] neighborsToString() {
        String[] datas = new String[neighbors.size()];
        for (int i = 0; i < datas.length; i++) {
            datas[i] = neighbors.get(i).data.toString();
        }
        return datas;
    }
}
