package pl.pomoku.algorithmservice.algorithm;

import pl.pomoku.algorithmservice.model.Vertex;

import java.util.*;

public class DepthFirstSearch {
    private static int pushOperationCount = 0;
    private static int popOperationCount = 0;
    private static int internalVertexesCount = 0;
    public static void traverse(Vertex<Integer> startVertex) {
        Deque<Vertex<Integer>> stack = new LinkedList<>();
        Set<Integer> externalVertices = new HashSet<>();

        startVertex.setVisited(true);
        stack.push(startVertex);
        pushOperationCount++;

        boolean contains = false;
        while (!stack.isEmpty()) {
            Vertex<Integer> current = stack.pop();
            popOperationCount++;
            System.out.println(current);
            for (Vertex<Integer> ngh : current.getNeighbors()) {
                if (!ngh.isVisited()) {
                    stack.push(ngh);
                    ngh.setVisited(true);

                    pushOperationCount++;
                    contains = true;
                    externalVertices.add(ngh.getData());
                }
            }

            if(contains){
                internalVertexesCount++;
                externalVertices.remove(current.getData());
            }
        }

        System.out.println("-------------------------------");
        System.out.println("Liczba operacji PUSH: " + pushOperationCount);
        System.out.println("Liczba operacji POP: " + popOperationCount);
        System.out.println("-------------------------------");
        System.out.println("Liczba wierzchołków WEWNĘTRZNYCH: " + internalVertexesCount);
        System.out.println("Liczba wierzchołków ZEWNĘTRZNYCH: " + externalVertices.size());
        System.out.println("-------------------------------");
//        System.out.println("Maksymalana wysokość stosu: " + stack.getCounter().getMaxSize());
////        System.out.println("Końcowa wysokość stosu: " + stack.size());
//        System.out.println("Wysokość drzewa rozpinającego: " + maxHeight);
//        System.out.println("-------------------------------");
    }

    public static void calculate(int[][] graph, int startVertexIdx) {
        List<Vertex<Integer>> vertices = new ArrayList<>();
        for (int x = 0; x < graph.length; x++) {
            vertices.add(new Vertex<>(x));
        }

        for (int x = 0; x < graph.length; x++) {
            for (int y = 0; y < graph[x].length; y++) {
                vertices.get(x).getNeighbors().add(vertices.get(graph[x][y]));
            }
        }

        traverse(vertices.get(startVertexIdx));
    }

    public static void main(String[] args) {
//        int[][] graph = {
//                {2, 4, 5, 7},
//                {4, 6},
//                {0, 3, 6, 7},
//                {2, 6, 7},
//                {0, 1, 5, 6, 7},
//                {0, 4, 6, 7},
//                {1, 2, 3, 4, 5},
//                {0, 2, 3, 4, 5}
//        };
        int[][] graph = {
                {4, 5},
                {3, 5, 6, 7},
                {3},
                {1, 2, 7},
                {0, 5},
                {0, 1, 4, 6, 7},
                {1, 5},
                {1, 3, 5}
        };

        calculate(graph, 0);
    }
}
