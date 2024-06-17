package pl.pomoku.algorithmservice.algorithm.huffman;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Vertex implements Comparable<Vertex> {
    String symbol;
    int freq;
    Vertex left;
    Vertex right;

    Vertex(String symbol, int freq) {
        this.symbol = symbol;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(Vertex other) {
        if (this.freq != other.freq) {
            return this.freq - other.freq;
        }

        List<Character> thisLeafLabels = getLeafLabels(this);
        List<Character> otherLeafLabels = getLeafLabels(other);

        String thisLeafLabelStr = leafLabelsToString(thisLeafLabels);
        String otherLeafLabelStr = leafLabelsToString(otherLeafLabels);

        return thisLeafLabelStr.compareTo(otherLeafLabelStr);
    }

    private List<Character> getLeafLabels(Vertex node) {
        List<Character> labels = new ArrayList<>();
        if (node == null) {
            return labels;
        }
        if (node.left == null && node.right == null) {
            labels.add(node.symbol.charAt(0));
        }
        if (node.left != null) {
            labels.addAll(getLeafLabels(node.left));
        }
        if (node.right != null) {
            labels.addAll(getLeafLabels(node.right));
        }
        return labels;
    }

    private String leafLabelsToString(List<Character> labels) {
        StringBuilder sb = new StringBuilder();
        for (Character label : labels) {
            sb.append(label);
        }
        return sb.toString();
    }

    public int height() {
        return calculateHeight(this);
    }

    private int calculateHeight(Vertex node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
