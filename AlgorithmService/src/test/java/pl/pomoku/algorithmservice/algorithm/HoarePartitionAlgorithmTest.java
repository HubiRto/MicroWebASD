package pl.pomoku.algorithmservice.algorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.pomoku.algorithmservice.dto.input.HoarePartitionInput;
import pl.pomoku.algorithmservice.dto.output.HoarePartitionOutput;
import pl.pomoku.algorithmservice.model.HoarePartitionStep;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HoarePartitionAlgorithmTest {

    @Test
    @DisplayName("Hoare Partition PJATK Result Test 1")
    public void hoarePartitionResultTest1() {
        Integer[] arr = {3,12,10,0,6,14,19,16,11,1,9};
        HoarePartitionOutput output = HoarePartition.calculate(new HoarePartitionInput(arr, 1));
        HoarePartitionStep step3 = output.getSteps().get(2);

        assertFalse(Arrays.equals(step3.getArr(), new Integer[]{3,11,1,16,2}) && step3.getIndex() == 4);
        assertEquals(output.getDepth(), 3);
        assertTrue(Arrays.equals(step3.getArr(), new Integer[]{19,16,11,12,14}) && step3.getIndex() == 1);
    }

    @Test
    @DisplayName("Hoare Partition PJATK Result Test 2")
    public void hoarePartitionResultTest2() {
        Integer[] arr = {11,9,16,18,6,4,0,5,2,8,1};
        HoarePartitionOutput output = HoarePartition.calculate(arr, 9);
        HoarePartitionStep step2 = output.getSteps().get(1);

        assertFalse(Arrays.equals(step2.getArr(), new Integer[]{16,18,6,4,11,5,2,8,9}) && step2.getIndex() == 10);
        assertTrue(output.getPartitionCount() > HoarePartition.calculate(arr, 5).getPartitionCount());
        assertEquals(output.getPartitionCount(), 4);
    }
}
