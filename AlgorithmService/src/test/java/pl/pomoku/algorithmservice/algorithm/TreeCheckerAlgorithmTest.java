package pl.pomoku.algorithmservice.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.pomoku.algorithmservice.algorithm.tree.treeChecker.TreeChecker;
import pl.pomoku.algorithmservice.dto.output.TreeCheckerOutput;
import pl.pomoku.algorithmservice.model.TreeCheckerStep;

public class TreeCheckerAlgorithmTest {

    @Test
    public void treeCheckerResultTest1() {
        TreeCheckerOutput output = new TreeChecker("7RT 5L 1R 8LR 3RL 11RR 4LRR 15RLL 10RLR 17RRR 6RLRL").calculate();
        Assertions.assertTrue(getByLevel(1, output).isRegular());
        Assertions.assertTrue(getByLevel(0, output).isLeftComplete());
        Assertions.assertNotEquals(output.getExternalEdges(), 3);
    }

    @Test
    public void treeCheckerResultTest2() {
        TreeCheckerOutput output = new TreeChecker("13RT 11L 6R 0LL 19LR 7RL 5RLR 18LLR 1LRL 10LRLR 15LLRL").calculate();
        Assertions.assertFalse(getByLevel(4, output).isFull());
        Assertions.assertTrue(getByLevel(1, output).isRegular());
        Assertions.assertEquals(output.getInternalEdges(), 8);
    }

    @Test
    public void treeCheckerResultTest3() {
        TreeCheckerOutput output = new TreeChecker("16RT 0L 9R 11LR 12RL 17RR 15LRR 7RLR 8RRL 6LRRR 14RLRL").calculate();
        Assertions.assertNotEquals(output.getInternalEdges(), 7);
        Assertions.assertEquals(output.getInternalEdges(), 8);
        Assertions.assertTrue(getByLevel(1, output).isRegular());
    }

    @Test
    public void treeCheckerResultTest4() {
        TreeCheckerOutput output = new TreeChecker("3RT 5L 0R 14LL 2LR 10RL 7RR 18RLL 12RLR 19RRL 6RLLL").calculate();
        Assertions.assertNotEquals(output.getExternalEdges(), 3);
        Assertions.assertTrue(getByLevel(1, output).isLeftComplete());
        Assertions.assertTrue(getByLevel(0, output).isRegular());
    }

    @Test
    public void treeCheckerResultTest5() {
        TreeCheckerOutput output = new TreeChecker("6RT 4L 3R 13LL 0LR 12RL 19LLL 1LLR 16RLR 14LLRL 5RLRR").calculate();
        Assertions.assertEquals(output.getInternalEdges(), 7);
        Assertions.assertEquals(output.getExternalEdges(), 4);
        Assertions.assertFalse(getByLevel(2, output).isFull());
    }

    @Test
    public void treeCheckerResultTest6() {
        TreeCheckerOutput output = new TreeChecker("12RT 16L 2R 0LL 17LR 15RL 14RR 18LRL 11LRR 3RRL 6LRRR").calculate();
        Assertions.assertNotEquals(output.getHeight(), 3);
        Assertions.assertEquals(output.getExternalEdges(), 5);
        Assertions.assertEquals(output.getHeight(), 4);
    }

    @Test
    public void treeCheckerResultTest7() {
        TreeCheckerOutput output = new TreeChecker("12RT 16L 2R 0LL 17LR 15RL 14RR 18LRL 11LRR 3RRL 6LRRR").calculate();
        Assertions.assertNotEquals(output.getHeight(), 3);
        Assertions.assertEquals(output.getExternalEdges(), 5);
        Assertions.assertEquals(output.getHeight(), 4);
    }


    private TreeCheckerStep getByLevel(int lvl, TreeCheckerOutput output) {
        return output.getSteps().get(output.getSteps().size() - lvl - 1);
    }
}
