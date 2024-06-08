package pl.pomoku.algorithmservice.utils;

import pl.pomoku.algorithmservice.algorithm.stackSequence.StackSequenceOperation;
import pl.pomoku.algorithmservice.algorithm.tree.Node;
import pl.pomoku.algorithmservice.algorithm.tree.bst.BinarySearchTreeSequenceOperation;
import pl.pomoku.algorithmservice.dto.input.BinarySearchTreeSequenceInput;
import pl.pomoku.algorithmservice.dto.input.StackSequenceInput;
import pl.pomoku.algorithmservice.dto.input.TraverseConverterInput;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HashUtils {

    /**
     * Generuje hash na podstawie tablicy Integerów.
     *
     * @param array tablica Integerów
     * @return wygenerowany hash
     */
    public static int hash(Integer[] array) {
        return Arrays.hashCode(array);
    }

    /**
     * Generuje hash na podstawie tablicy Integerów i pojedynczej wartości int.
     *
     * @param array tablica Integerów
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
     * Generuje hash na podstawie instancji TraverseConverterInput.
     *
     * @param input instancja TraverseConverterInput
     * @return wygenerowany hash
     */
    public static int hash(TraverseConverterInput input) {
        int result = Arrays.hashCode(input.getArr());
        result = 31 * result + (input.getFrom() != null ? input.getFrom().hashCode() : 0);
        result = 31 * result + (input.getTo() != null ? input.getTo().hashCode() : 0);
        return result;
    }

    /**
     * Generuje hash na podstawie instancji Node.
     *
     * @param node korzeń drzewa
     * @return wygenerowany hash
     */
    public static int hash(Node<Integer> node) {
        if (node == null) {
            return 0;
        }
        int result = Objects.hash(node.getData());
        result = 31 * result + hash(node.getLeft());
        result = 31 * result + hash(node.getRight());
        return result;
    }

    /**
     * Generuje hash na podstawie instancji StackSequenceInput.
     *
     * @param input instancja StackSequenceInput
     * @return wygenerowany hash
     */
    public static int hash(StackSequenceInput input) {
        return Arrays.hashCode(input.getElements());
    }

    /**
     * Generuje hash na podstawie tablicy StackSequenceOperation.
     *
     * @param elements tablica StackSequenceOperation
     * @return wygenerowany hash
     */
    public static int hash(StackSequenceOperation[] elements) {
        return Arrays.hashCode(elements);
    }

    /**
     * Generuje hash na podstawie instancji StackSequenceOperation.
     *
     * @param element instancja StackSequenceOperation
     * @return wygenerowany hash
     */
    public static int hash(StackSequenceOperation element) {
        return Objects.hash(element.getType(), element.getValue(), element.getElement());
    }

    /**
     * Generuje hash na podstawie dwóch tablic intów.
     *
     * @param array1 pierwsza tablica intów
     * @param array2 druga tablica intów
     * @return wygenerowany hash
     */
    public static int hash(Integer[] array1, Integer[] array2) {
        int result = Arrays.hashCode(array1);
        result = 31 * result + Arrays.hashCode(array2);
        return result;
    }

    /**
     * Generuje hash na podstawie instancji BinarySearchTreeSequenceOperation.
     *
     * @param operation instancja BinarySearchTreeSequenceOperation
     * @return wygenerowany hash
     */
    public static int hash(BinarySearchTreeSequenceOperation operation) {
        if (operation == null) {
            return 0;
        }
        int result = Objects.hash(operation.getType(), operation.getValue());
        result = 31 * result + hash(operation.getChild());
        return result;
    }

    /**
     * Generuje hash na podstawie tablicy BinarySearchTreeSequenceOperation.
     *
     * @param operations tablica BinarySearchTreeSequenceOperation
     * @return wygenerowany hash
     */
    public static int hash(BinarySearchTreeSequenceOperation[] operations) {
        return Arrays.hashCode(
                Arrays.stream(operations)
                        .mapToInt(HashUtils::hash)
                        .toArray()
        );
    }

    /**
     * Generuje hash na podstawie instancji BinarySearchTreeSequenceInput.
     *
     * @param input instancja BinarySearchTreeSequenceInput
     * @return wygenerowany hash
     */
    public static int hash(BinarySearchTreeSequenceInput input) {
        int result = Arrays.hashCode(input.getInitArray());
        result = 31 * result + hash(input.getOperations());
        return result;
    }
}
