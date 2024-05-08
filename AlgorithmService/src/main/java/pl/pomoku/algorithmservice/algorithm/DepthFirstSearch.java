package pl.pomoku.algorithmservice.algorithm;

import pl.pomoku.algorithmservice.model.Vertex;

import java.util.*;

public class DepthFirstSearch {
    private static int pushOperationCount = 0;
    private static int popOperationCount = 0;
    private static int leafCount = 0;
    private static int internalCount = 0;
    private static int maxDepth = 0;
    private static int maxStackSize = 0;
    private static final Map<Vertex<Integer>, Vertex<Integer>> parentMap = new HashMap<>();

    public static void traverse(Vertex<Integer> startVertex) {
        Deque<Vertex<Integer>> stack = new LinkedList<>();

        startVertex.setVisited(true);
        startVertex.setDepth(0);
        stack.push(startVertex);
        maxStackSize++;
        pushOperationCount++;
        parentMap.put(startVertex, null);

        while (!stack.isEmpty()) {
            Vertex<Integer> current = stack.pop();
            popOperationCount++;
            System.out.println(current);

            maxDepth = Math.max(maxDepth, current.getDepth());
            boolean hasUnvisitedNeighbors = false;

            for (Vertex<Integer> ngh : current.getNeighbors()) {
                if (!ngh.isVisited()) {
                    stack.push(ngh);
                    if(maxStackSize < stack.size()) {
                        maxStackSize = stack.size();
                    }
                    ngh.setVisited(true);
                    ngh.setDepth(current.getDepth() + 1);
                    hasUnvisitedNeighbors = true;
                    parentMap.put(ngh, current);
                    pushOperationCount++;
                }
            }

            if (hasUnvisitedNeighbors) {
                internalCount++;
            } else {
                leafCount++;
            }
        }

        System.out.println("-------------------------------");
        System.out.println("Liczba operacji PUSH: " + pushOperationCount);
        System.out.println("Liczba operacji POP: " + popOperationCount);
        System.out.println("Liczba wierzchołków zewnętrznych: " + leafCount);
        System.out.println("Liczba wierzchołków wewnętrznych: " + internalCount);
        System.out.println("Maksymalna głębokość drzewa: " + maxDepth);
        System.out.println("Maksymalna wysokosc stosu: " + maxStackSize);
        System.out.println("-------------------------------");
    }

    public static void printPaths(List<Vertex<Integer>> vertices, Vertex<Integer> startVertex) {
        for (Vertex<Integer> vertex : vertices) {
            if (vertex == startVertex) {
                continue;
            }
            LinkedList<Integer> path = new LinkedList<>();
            for (Vertex<Integer> at = vertex; at != null; at = parentMap.get(at)) {
                path.addFirst(at.getData());
            }
            System.out.println("Ścieżka od " + startVertex.getData() + " do " + (vertex != null ? vertex.getData() : null) + ": " + path);
        }
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

        Vertex<Integer> startVertex = vertices.get(startVertexIdx);
        traverse(startVertex);
        printPaths(vertices, startVertex);
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
//        int[][] graph = {
//                {4, 5},
//                {3, 5, 6, 7},
//                {3},
//                {1, 2, 7},
//                {0, 5},
//                {0, 1, 4, 6, 7},
//                {1, 5},
//                {1, 3, 5}
//        };

        int[][] graph = {
                {2,6},
                {2,4,5,6,7},
                {0,1,4,5,7},
                {5},
                {1,2},
                {1,2,3},
                {0,1},
                {1,2}
        };

//        int[][] graph = {
//                {2,4},
//                {4,5,6},
//                {0,4,5},
//                {6,7},
//                {0,1,2},
//                {1,2},
//                {1,3,7},
//                {3,6}
//        };

//        int[][] graph = {
//                {1,2,4,7},
//                {0,2,4,5},
//                {0,1,3,7},
//                {2,4,5,6},
//                {0,1,3,7},
//                {1,3,6},
//                {3,5},
//                {0,2,4}
//        };

        calculate(graph, 3);
    }
}
