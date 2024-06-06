package pl.pomoku.algorithmservice.algorithm;

import org.springframework.http.HttpStatus;
import pl.pomoku.algorithmservice.dto.input.HoarePartitionInput;
import pl.pomoku.algorithmservice.dto.output.HoarePartitionOutput;
import pl.pomoku.algorithmservice.exception.AppException;
import pl.pomoku.algorithmservice.model.HoarePartitionStep;

import java.util.Arrays;

public class HoarePartition {

    /**
     * Calculates the k-th smallest element of an array using the Hoare partition method. This is the main entry point for clients.
     *
     * @param input The input data encapsulating the array and the rank (k).
     * @return An instance of {@link HoarePartitionOutput} containing the results, detailed steps, and depth of the computation.
     * @throws IllegalArgumentException if the input array is empty.
     */
    public static HoarePartitionOutput calculate(HoarePartitionInput input) {
        return calculate(input.getArr(), input.getK());
    }

    /**
     * Overloaded method to initiate the partition calculation. It prepares the output object and starts the recursive partitioning.
     *
     * @param arr The array from which to find the k-th smallest element.
     * @param k   The index of the element to find (zero-based).
     * @return An instance of {@link HoarePartitionOutput} with the result and other details of the computation.
     * @throws IllegalArgumentException if the input array is empty.
     */
    public static HoarePartitionOutput calculate(Integer[] arr, int k) {
        HoarePartitionOutput output = new HoarePartitionOutput();
        output.setResult(calculate(arr, k, 0, output));
        return output;
    }

    /**
     * Core recursive method for calculating the k-th smallest element using the Hoare partition. It performs the actual partitioning and recursive calls.
     *
     * @param arr    The array or subarray currently being partitioned.
     * @param k      The adjusted rank of the element to find in the current subarray context.
     * @param depth  The current depth of the recursion for traceability.
     * @param output The output object to record each step and the overall depth.
     * @return The value of the k-th smallest element found in the array.
     * @throws AppException if the input array is empty, detailed with a specific HTTP status code for appropriate client response handling.
     */
    public static int calculate(Integer[] arr, int k, int depth, HoarePartitionOutput output) {
        output.setDepth(depth);
        output.addStep(new HoarePartitionStep(Arrays.copyOf(arr, arr.length), k));

        int m, n = arr.length;

        if (n == 0) {
            throw new AppException("Array must not be empty", HttpStatus.BAD_REQUEST);
        }

        m = Partition.calculate(arr);
        output.setPartitionCount(output.getPartitionCount() + 1);

        if (n - m == k) {
            return m;
        } else if (n - m > k) {
            Integer[] subarray = Arrays.copyOfRange(arr, m + 1, n);
            return m + 1 + calculate(subarray, k, depth + 1, output);
        } else {
            Integer[] subarray = Arrays.copyOfRange(arr, 0, m);
            return calculate(subarray, k - (n - m), depth + 1, output);
        }
    }
}
