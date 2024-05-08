package pl.pomoku.algorithmservice.algorithm;

import pl.pomoku.algorithmservice.dto.input.DepthFirstSearchInput;
import pl.pomoku.algorithmservice.dto.output.DepthFirstSearchOutput;
import pl.pomoku.algorithmservice.model.Vertex;

import java.util.*;

public class DepthFirstSearch {

    public static DepthFirstSearchOutput calculate(DepthFirstSearchInput input) {
        return calculate(input.getGraph(), input.getStartIndex());
    }

    public static DepthFirstSearchOutput calculate(int[][] graph, int startVertexIdx) {
        List<Vertex<Integer>> vertices = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            vertices.add(new Vertex<>(i));
        }

        for (int i = 0; i < graph.length; i++) {
            for (int neighborIdx : graph[i]) {
                vertices.get(i).getNeighbors().add(vertices.get(neighborIdx));
            }
        }

        Map<Integer, List<Integer>> paths = new HashMap<>();
        List<Integer> traverse = new ArrayList<>();
        Map<Vertex<Integer>, Vertex<Integer>> parentMap = new HashMap<>();
        Deque<Vertex<Integer>> stack = new LinkedList<>();
        Vertex<Integer> startVertex = vertices.get(startVertexIdx);
        int pushCount = 0, popCount = 0, maxDepth = 0, maxStack = 0, externalCount = 0, internalCount = 0;

        startVertex.setVisited(true);
        stack.push(startVertex);
        pushCount++;
        parentMap.put(startVertex, null);
        maxStack++;

        while (!stack.isEmpty()) {
            Vertex<Integer> current = stack.pop();
            popCount++;
            traverse.add(current.getData());

            int currentDepth = current.getDepth();
            maxDepth = Math.max(maxDepth, currentDepth);
            boolean hasUnvisitedNeighbors = false;

            for (Vertex<Integer> neighbor : current.getNeighbors()) {
                if (!neighbor.isVisited()) {
                    stack.push(neighbor);
                    neighbor.setVisited(true);
                    neighbor.setDepth(currentDepth + 1);
                    maxStack = Math.max(maxStack, stack.size());
                    hasUnvisitedNeighbors = true;
                    parentMap.put(neighbor, current);
                    pushCount++;
                }
            }

            if (hasUnvisitedNeighbors) {
                internalCount++;
            } else {
                externalCount++;
            }
        }
        for (Vertex<Integer> vertex : vertices) {
            if (vertex != startVertex) {
                LinkedList<Integer> path = new LinkedList<>();
                for (Vertex<Integer> at = vertex; at != null; at = parentMap.get(at)) {
                    path.addFirst(at.getData());
                }
                if (vertex != null) {
                    paths.put(vertex.getData(), path);
                }
            }
        }

        return new DepthFirstSearchOutput(paths, pushCount, popCount, externalCount, internalCount, maxDepth, maxStack, traverse);
    }
}
