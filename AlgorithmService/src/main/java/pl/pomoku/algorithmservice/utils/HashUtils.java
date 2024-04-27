package pl.pomoku.algorithmservice.utils;

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
    public static int hash(int[] array) {
        return Arrays.hashCode(array);
    }

    /**
     * Generuje hash na podstawie tablicy intów i pojedynczej wartości int.
     *
     * @param array tablica intów
     * @param value wartość int
     * @return wygenerowany hash
     */
    public static int hash(int[] array, int value) {
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
}

