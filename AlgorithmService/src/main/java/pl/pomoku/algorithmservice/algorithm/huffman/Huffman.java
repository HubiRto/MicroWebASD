package pl.pomoku.algorithmservice.algorithm.huffman;

import pl.pomoku.algorithmservice.algorithm.heap.Heap;
import pl.pomoku.algorithmservice.algorithm.heap.MinimumHeap;
import pl.pomoku.algorithmservice.dto.output.HuffmanOutput;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static pl.pomoku.algorithmservice.algorithm.heap.Heap.getLeafLabels;

public class Huffman {

    public static HuffmanOutput calculate(Vertex[] input) {
        HuffmanOutput.HuffmanOutputBuilder outputBuilder = HuffmanOutput.builder();

        Heap<Vertex> heap = new MinimumHeap<>();
        for (Vertex vertex : input) {
            heap.insert(vertex);
        }

        while (heap.size() > 1) {
            Vertex tmp1 = heap.getRoot();
            Vertex tmp2 = heap.getRoot();

            Vertex merged = new Vertex(tmp1.symbol + tmp2.symbol, tmp1.freq + tmp2.freq);
            merged.left = tmp1;
            merged.right = tmp2;

            heap.insert(merged);
        }

        Vertex root = heap.getRoot();
        if (root == null) {
            return outputBuilder.codes(new HashMap<>()).leafLabels("").treeHeight(0).build();
        }

        Map<String, String> codes = getCodes(root, "", new HashMap<>());
        List<String> leafLabels = getLeafLabels(root);
        int treeHeight = root.height() - 1;

        return outputBuilder.codes(codes).leafLabels(String.join("", leafLabels)).treeHeight(treeHeight).build();
    }

    public static HuffmanOutput huffman(Object... data) {
        if (data.length % 2 != 0) {
            throw new IllegalArgumentException("Data must be provided in pairs of symbol and frequency.");
        }

        Vertex[] vertices = new Vertex[data.length / 2];
        for (int i = 0; i < data.length; i += 2) {
            String symbol = (String) data[i];
            int freq = (int) data[i + 1];
            vertices[i / 2] = new Vertex(symbol, freq);
        }
        return calculate(vertices);
    }

    private static Map<String, String> getCodes(Vertex root, String code, Map<String, String> codes) {
        if (root.left == null && root.right == null) {
            codes.put(root.symbol, code);
            return codes;
        }
        if (root.left != null) {
            getCodes(root.left, code + "0", codes);
        }
        if (root.right != null) {
            getCodes(root.right, code + "1", codes);
        }
        return codes;
    }
}