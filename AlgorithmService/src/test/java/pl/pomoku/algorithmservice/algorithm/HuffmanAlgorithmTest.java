package pl.pomoku.algorithmservice.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.pomoku.algorithmservice.algorithm.huffman.Huffman;
import pl.pomoku.algorithmservice.dto.output.HuffmanOutput;

public class HuffmanAlgorithmTest {

    @Test
    public void huffmanAlgorithmTest1() {
        HuffmanOutput output = Huffman.huffman("S", 6, "X", 11, "F", 16, "Q", 17, "W", 10, "P", 8, "E", 2, "M", 14);
        Assertions.assertEquals(5, output.getTreeHeight());
        Assertions.assertEquals("00", output.getCodes().get("F"));
        Assertions.assertNotEquals(4, output.getTreeHeight());
    }

    @Test
    public void huffmanAlgorithmTest2() {
        HuffmanOutput output = Huffman.huffman("R", 9, "D", 6, "U", 8, "M", 13, "K", 5, "O", 17, "L", 16, "Z", 3);
        Assertions.assertEquals("00", output.getCodes().get("L"));
        Assertions.assertEquals(4, output.getTreeHeight());
        Assertions.assertEquals("LOZKRMDU", output.getLeafLabels());
    }

    @Test
    public void huffmanAlgorithmTest3() {
        HuffmanOutput output = Huffman.huffman("E", 11, "J", 15, "B", 8, "K", 9, "D", 1, "F", 16, "R", 13, "G", 17);
        Assertions.assertNotEquals("GKEDBRJF", output.getLeafLabels());
        Assertions.assertEquals("GDBKERJF", output.getLeafLabels());
        Assertions.assertNotEquals(5, output.getTreeHeight());
    }

    @Test
    public void huffmanAlgorithmTest4() {
        HuffmanOutput output = Huffman.huffman("H", 6, "U", 19, "B", 11, "Y", 2, "K", 3, "F", 18, "N", 10, "I", 12);
        Assertions.assertNotEquals("FHYUKNBI", output.getLeafLabels());
        Assertions.assertEquals("111", output.getCodes().get("I"));
        Assertions.assertEquals("FUNBYKHI", output.getLeafLabels());
    }
}