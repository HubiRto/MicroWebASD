package pl.pomoku.algorithmservice.utils;

import pl.pomoku.algorithmservice.algorithm.stackSequence.StackSequenceOperation;
import pl.pomoku.algorithmservice.algorithm.tree.Node;
import pl.pomoku.algorithmservice.dto.input.StackSequenceInput;
import pl.pomoku.algorithmservice.dto.input.TraverseConverterInput;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HashUtils {

    /**
     * Generuje hash na podstawie tablicy intów.
     *
     * @param array tablica intów
     * @return wygenerowany hash
     */
    public static int hash(Integer[] array) {
        return Arrays.hashCode(array);
    }

    /**
     * Generuje hash na podstawie tablicy intów i pojedynczej wartości int.
     *
     * @param array tablica intów
     * @param value wartość int
     * @return wygenerowany hash
     */
    public static int hash(Integer[] array, int value) {
        int result = Arrays.hashCode(array);
        return 31 * result + Integer.hashCode(value);
    }

    /**
     * Generuje hash na podstawie listy Integerów.
     *
     * @param list lista Integerów
     * @return wygenerowany hash
     */
    public static int hash(List<Integer> list) {
        return Objects.hash(list);
    }

    /**
     * Generuje hash na podstawie grafu i pojedynczej wartości int.
     *
     * @param graph graf
     * @param value wartość int
     * @return wygenerowany hash
     */
    public static int hash(Integer[][] graph, int value) {
        int result = Arrays.deepHashCode(graph);
        return 31 * result + Integer.hashCode(value);
    }

    /**
     * Generates a hash based on TraverseConverterInput.
     *
     * @param input TraverseConverterInput instance
     * @return generated hash
     */
    public static int hash(TraverseConverterInput input) {
        int result = Arrays.hashCode(input.getArr());
        result = 31 * result + (input.getFrom() != null ? input.getFrom().hashCode() : 0);
        result = 31 * result + (input.getTo() != null ? input.getTo().hashCode() : 0);
        return result;
    }

    /**
     * Generates a hash based on a Node instance.
     *
     * @param node the root node of the tree
     * @return generated hash
     */
    public static int hash(Node node) {
        if (node == null) {
            return 0;
        }
        int result = Objects.hash(node.getValue());
        result = 31 * result + hash(node.getLeft());
        result = 31 * result + hash(node.getRight());
        return result;
    }

    public static int hash(StackSequenceInput input) {
        return Arrays.hashCode(input.getElements());
    }

    public static int hash(StackSequenceOperation[] elements) {
        return Arrays.hashCode(elements);
    }

    public static int hash(StackSequenceOperation element) {
        return Objects.hash(element.getType(), element.getValue(), element.getElement());
    }
}

