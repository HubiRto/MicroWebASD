package pl.pomoku.algorithmservice.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.pomoku.algorithmservice.dto.output.DepthFirstSearchOutput;

import java.util.List;

public class DepthFirstSearchAlgorithmTest {

    @Test
    public void depthFirstSearchResultTest1() {
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

        DepthFirstSearchOutput output = DepthFirstSearch.calculate(graph, 0);

        Assertions.assertEquals(output.getPushOperationCount(), 8);
        Assertions.assertArrayEquals(toArray(output.getTraverse()), new int[]{0, 5, 7, 3, 2, 6, 1, 4});
        Assertions.assertNotEquals(output.getMaxDepth(), 3);
    }

    @Test
    public void depthFirstSearchResultTest2() {
        int[][] graph = {
                {2, 4},
                {4, 5, 6},
                {0, 4, 5},
                {6, 7},
                {0, 1, 2},
                {1, 2},
                {1, 3, 7},
                {3, 6}
        };

        DepthFirstSearchOutput output = DepthFirstSearch.calculate(graph, 5);

        Assertions.assertEquals(output.getExternalCount(), 4);
        Assertions.assertNotEquals(output.getMaxDepth(), 4);
        Assertions.assertTrue(output.getPaths().get(4).contains(2));
    }

    @Test
    public void depthFirstSearchResultTest3() {
        int[][] graph = {
                {2, 6},
                {2, 4, 5, 6, 7},
                {0, 1, 4, 5, 7},
                {5},
                {1, 2},
                {1, 2, 3},
                {0, 1},
                {1, 2}
        };

        DepthFirstSearchOutput output = DepthFirstSearch.calculate(graph, 3);

        Assertions.assertEquals(output.getMaxDepth(), 4);
        Assertions.assertEquals(output.getPushOperationCount(), 8);
        Assertions.assertArrayEquals(toArray(output.getTraverse()), new int[]{3, 5, 2, 7, 4, 0, 6, 1});
    }

    @Test
    public void depthFirstSearchResultTest4() {
        int[][] graph = {
                {1, 2, 3, 4, 5, 7},
                {0, 3, 4},
                {0, 5, 7},
                {0, 1, 4, 6},
                {0, 1, 3, 5},
                {0, 2, 4, 7},
                {3},
                {0, 2, 5}
        };

        DepthFirstSearchOutput output = DepthFirstSearch.calculate(graph, 7);

        Assertions.assertEquals(output.getMaxStackSize(), 4);
        Assertions.assertTrue(output.getPaths().get(6).contains(5));
        Assertions.assertNotEquals(output.getPushOperationCount(), 7);
    }

    @Test
    public void depthFirstSearchResultTest5() {
        int[][] graph = {
                {1, 3, 6, 7},
                {0, 2, 3, 5, 7},
                {1, 5, 6},
                {0, 1, 4, 7},
                {3, 7},
                {1, 2, 7},
                {0, 2},
                {0, 1, 3, 4, 5}
        };

        DepthFirstSearchOutput output = DepthFirstSearch.calculate(graph, 7);

        Assertions.assertArrayEquals(toArray(output.getTraverse()), new int[]{7, 5, 2, 6, 4, 3, 1, 0});
        Assertions.assertNotEquals(output.getMaxStackSize(), 6);
        Assertions.assertNotEquals(output.getExternalCount(), 6);
    }

    @Test
    public void depthFirstSearchResultTest6() {
        int[][] graph = {
                {1, 3, 5},
                {0, 2, 3, 5, 6},
                {1, 3, 4},
                {0, 1, 2, 6},
                {2, 5, 6, 7},
                {0, 1, 4, 6, 7},
                {1, 3, 4, 5},
                {4, 5}
        };

        DepthFirstSearchOutput output = DepthFirstSearch.calculate(graph, 3);

        Assertions.assertEquals(output.getPushOperationCount(), 8);
        Assertions.assertNotEquals(output.getInternalCount(), 4);
        Assertions.assertEquals(output.getInternalCount(), 3);
    }

    @Test
    public void depthFirstSearchResultTest7() {
        int[][] graph = {
                {1, 2, 4, 5, 6, 7},
                {0, 5},
                {0, 5, 6, 7},
                {4, 7},
                {0, 3, 5, 6},
                {0, 1, 2, 4},
                {0, 2, 4, 7},
                {0, 2, 3, 6}
        };

        DepthFirstSearchOutput output = DepthFirstSearch.calculate(graph, 0);

        Assertions.assertEquals(output.getInternalCount(), 2);
        Assertions.assertEquals(output.getExternalCount(), 6);
        Assertions.assertEquals(output.getMaxStackSize(), 6);
    }

    @Test
    public void depthFirstSearchResultTest8() {
        int[][] graph = {
                {1, 2, 4, 7},
                {0, 2, 4, 5},
                {0, 1, 3, 7},
                {2, 4, 5, 6},
                {0, 1, 3, 7},
                {1, 3, 6},
                {3, 5},
                {0, 2, 4}
        };

        DepthFirstSearchOutput output = DepthFirstSearch.calculate(graph, 2);

        Assertions.assertEquals(output.getExternalCount(), 5);
        Assertions.assertNotEquals(output.getPushOperationCount(), 7);
        Assertions.assertFalse(output.getPaths().get(7).contains(4));
    }

    @Test
    public void depthFirstSearchResultTest9() {
        int[][] graph = {
                {3, 7},
                {5, 6, 7},
                {4, 5, 6, 7},
                {0, 4, 5, 7},
                {2, 3, 5},
                {1, 2, 3, 4, 6},
                {1, 2, 5},
                {0, 1, 2, 3}
        };

        DepthFirstSearchOutput output = DepthFirstSearch.calculate(graph, 5);

        Assertions.assertEquals(output.getMaxStackSize(), 5);
        Assertions.assertTrue(output.getPaths().get(7).contains(3));
        Assertions.assertEquals(output.getExternalCount(), 6);
    }

    @Test
    public void depthFirstSearchResultTest10() {
        int[][] graph = {
                {4, 5, 6},
                {2, 3, 5, 6},
                {1, 3, 4, 6},
                {1, 2, 6},
                {0, 2, 7},
                {0, 1, 6, 7},
                {0, 1, 2, 3, 5, 7},
                {4, 5, 6}
        };

        DepthFirstSearchOutput output = DepthFirstSearch.calculate(graph, 1);

        Assertions.assertEquals(output.getPopOperationCount(), 8);
        Assertions.assertFalse(output.getPaths().get(6).contains(0));
        Assertions.assertNotEquals(output.getMaxStackSize(), 4);
    }

    public static int[] toArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}