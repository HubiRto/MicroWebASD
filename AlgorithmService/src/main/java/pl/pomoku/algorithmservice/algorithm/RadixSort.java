package pl.pomoku.algorithmservice.algorithm;

import pl.pomoku.algorithmservice.dto.input.RadixSortInput;
import pl.pomoku.algorithmservice.dto.output.RadixSortOutput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RadixSort {

    public static RadixSortOutput calculate(RadixSortInput input) {
        return calculate(input.getArr(), input.getD());
    }

    public static RadixSortOutput calculate(int[] arr, int d) {
        RadixSortOutput output = new RadixSortOutput();
        List<Queue<Integer>> queues = new ArrayList<>();

        for (int i = 0; i < 10 * d; i++) {
            queues.add(new LinkedList<>());
        }

        for (int exp = 0; exp < d; exp++) {
            int exp10 = (int) Math.pow(10, exp);
            for (int num : arr) {
                int bucketIndex = (num / exp10) % 10 + (10 * exp);
                queues.get(bucketIndex).add(num);
                output.setInOperationCount(output.getInOperationCount() + 1);
                if (queues.get(bucketIndex).size() > output.getMaxQueueLength()) {
                    output.setMaxQueueLength(queues.get(bucketIndex).size());
                }
            }

            int index = 0;
            for (Queue<Integer> queue : queues) {
                while (!queue.isEmpty()) {
                    arr[index++] = queue.remove();
                    output.setFirstOperationCount(output.getFirstOperationCount() + 1);
                    output.setOutOperationCount(output.getOutOperationCount() + 1);
                }
            }
            output.getSteps().add(exp, arr);
        }
        return output;
    }
}
