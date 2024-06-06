package pl.pomoku.algorithmservice.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.pomoku.algorithmservice.dto.output.FirstSearchOutput;
import pl.pomoku.algorithmservice.utils.ArrayUtils;

public class DepthFirstSearchAlgorithmTest {

    @Test
    public void depthFirstSearchResultTest1() {
        Integer[][] graph = {
                {4, 5},
                {3, 5, 6, 7},
                {3},
                {1, 2, 7},
                {0, 5},
                {0, 1, 4, 6, 7},
                {1, 5},
                {1, 3, 5}
        };

        FirstSearchOutput output = new DepthFirstSearch().calculate(graph, 0);

        Assertions.assertEquals(output.getInOperationCount(), 8);
        Assertions.assertArrayEquals(ArrayUtils.listToArray(output.getTraverse()), new int[]{0, 5, 7, 3, 2, 6, 1, 4});
        Assertions.assertNotEquals(output.getMaxDepth(), 3);
    }

    @Test
    public void depthFirstSearchResultTest2() {
        Integer[][] graph = {
                {2, 4},
                {4, 5, 6},
                {0, 4, 5},
                {6, 7},
                {0, 1, 2},
                {1, 2},
                {1, 3, 7},
                {3, 6}
        };

        FirstSearchOutput output = new DepthFirstSearch().calculate(graph, 5);

        Assertions.assertEquals(output.getExternalCount(), 4);
        Assertions.assertNotEquals(output.getMaxDepth(), 4);
        Assertions.assertTrue(output.getPaths().get(4).contains(2));
    }

    @Test
    public void depthFirstSearchResultTest3() {
        Integer[][] graph = {
                {2, 6},
                {2, 4, 5, 6, 7},
                {0, 1, 4, 5, 7},
                {5},
                {1, 2},
                {1, 2, 3},
                {0, 1},
                {1, 2}
        };

        FirstSearchOutput output = new DepthFirstSearch().calculate(graph, 3);

        Assertions.assertEquals(output.getMaxDepth(), 4);
        Assertions.assertEquals(output.getInOperationCount(), 8);
        Assertions.assertArrayEquals(ArrayUtils.listToArray(output.getTraverse()), new int[]{3, 5, 2, 7, 4, 0, 6, 1});
    }

    @Test
    public void depthFirstSearchResultTest4() {
        Integer[][] graph = {
                {1, 2, 3, 4, 5, 7},
                {0, 3, 4},
                {0, 5, 7},
                {0, 1, 4, 6},
                {0, 1, 3, 5},
                {0, 2, 4, 7},
                {3},
                {0, 2, 5}
        };

        FirstSearchOutput output = new DepthFirstSearch().calculate(graph, 7);

        Assertions.assertEquals(output.getMaxDequeSize(), 4);
        Assertions.assertTrue(output.getPaths().get(6).contains(5));
        Assertions.assertNotEquals(output.getInOperationCount(), 7);
    }

    @Test
    public void depthFirstSearchResultTest5() {
        Integer[][] graph = {
                {1, 3, 6, 7},
                {0, 2, 3, 5, 7},
                {1, 5, 6},
                {0, 1, 4, 7},
                {3, 7},
                {1, 2, 7},
                {0, 2},
                {0, 1, 3, 4, 5}
        };

        FirstSearchOutput output = new DepthFirstSearch().calculate(graph, 7);

        Assertions.assertArrayEquals(ArrayUtils.listToArray(output.getTraverse()), new int[]{7, 5, 2, 6, 4, 3, 1, 0});
        Assertions.assertNotEquals(output.getMaxDequeSize(), 6);
        Assertions.assertNotEquals(output.getExternalCount(), 6);
    }

    @Test
    public void depthFirstSearchResultTest6() {
        Integer[][] graph = {
                {1, 3, 5},
                {0, 2, 3, 5, 6},
                {1, 3, 4},
                {0, 1, 2, 6},
                {2, 5, 6, 7},
                {0, 1, 4, 6, 7},
                {1, 3, 4, 5},
                {4, 5}
        };

        FirstSearchOutput output = new DepthFirstSearch().calculate(graph, 3);

        Assertions.assertEquals(output.getInOperationCount(), 8);
        Assertions.assertNotEquals(output.getInternalCount(), 4);
        Assertions.assertEquals(output.getInternalCount(), 3);
    }

    @Test
    public void depthFirstSearchResultTest7() {
        Integer[][] graph = {
                {1, 2, 4, 5, 6, 7},
                {0, 5},
                {0, 5, 6, 7},
                {4, 7},
                {0, 3, 5, 6},
                {0, 1, 2, 4},
                {0, 2, 4, 7},
                {0, 2, 3, 6}
        };

        FirstSearchOutput output = new DepthFirstSearch().calculate(graph, 0);

        Assertions.assertEquals(output.getInternalCount(), 2);
        Assertions.assertEquals(output.getExternalCount(), 6);
        Assertions.assertEquals(output.getMaxDequeSize(), 6);
    }

    @Test
    public void depthFirstSearchResultTest8() {
        Integer[][] graph = {
                {1, 2, 4, 7},
                {0, 2, 4, 5},
                {0, 1, 3, 7},
                {2, 4, 5, 6},
                {0, 1, 3, 7},
                {1, 3, 6},
                {3, 5},
                {0, 2, 4}
        };

        FirstSearchOutput output = new DepthFirstSearch().calculate(graph, 2);

        Assertions.assertEquals(output.getExternalCount(), 5);
        Assertions.assertNotEquals(output.getInOperationCount(), 7);
        Assertions.assertFalse(output.getPaths().get(7).contains(4));
    }

    @Test
    public void depthFirstSearchResultTest9() {
        Integer[][] graph = {
                {3, 7},
                {5, 6, 7},
                {4, 5, 6, 7},
                {0, 4, 5, 7},
                {2, 3, 5},
                {1, 2, 3, 4, 6},
                {1, 2, 5},
                {0, 1, 2, 3}
        };

        FirstSearchOutput output = new DepthFirstSearch().calculate(graph, 5);

        Assertions.assertEquals(output.getMaxDequeSize(), 5);
        Assertions.assertTrue(output.getPaths().get(7).contains(3));
        Assertions.assertEquals(output.getExternalCount(), 6);
    }

    @Test
    public void depthFirstSearchResultTest10() {
        Integer[][] graph = {
                {4, 5, 6},
                {2, 3, 5, 6},
                {1, 3, 4, 6},
                {1, 2, 6},
                {0, 2, 7},
                {0, 1, 6, 7},
                {0, 1, 2, 3, 5, 7},
                {4, 5, 6}
        };

        FirstSearchOutput output = new DepthFirstSearch().calculate(graph, 1);

        Assertions.assertEquals(output.getOutOperationCount(), 8);
        Assertions.assertFalse(output.getPaths().get(6).contains(0));
        Assertions.assertNotEquals(output.getMaxDequeSize(), 4);
    }
}