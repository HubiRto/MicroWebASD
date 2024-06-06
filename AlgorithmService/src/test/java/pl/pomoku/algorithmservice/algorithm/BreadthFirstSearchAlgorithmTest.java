package pl.pomoku.algorithmservice.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.pomoku.algorithmservice.dto.output.FirstSearchOutput;

public class BreadthFirstSearchAlgorithmTest {

    @Test
    public void depthFirstSearchResultTest1() {
        Integer[][] graph = {
                {1, 3, 5, 7},
                {0, 2, 6},
                {1, 4, 5, 6},
                {0, 4, 7},
                {2, 3, 5},
                {0, 2, 4},
                {1, 2, 7},
                {0, 3, 6}
        };

        FirstSearchOutput output = new BreadthFirstSearch().calculate(graph, 0);

        Assertions.assertNotEquals(output.getInternalCount(), 4);
        Assertions.assertEquals(output.getInternalCount(), 3);
        Assertions.assertEquals(output.getExternalCount(), 5);
    }
}