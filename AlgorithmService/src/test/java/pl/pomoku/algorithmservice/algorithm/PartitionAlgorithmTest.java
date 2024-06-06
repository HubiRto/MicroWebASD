package pl.pomoku.algorithmservice.algorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.pomoku.algorithmservice.dto.output.PartitionOutput;

import static org.junit.jupiter.api.Assertions.*;
import static pl.pomoku.algorithmservice.utils.ArrayUtils.assertArrayNotEquals;

public class PartitionAlgorithmTest {

    @Test
    @DisplayName("Partition PJATK Result Test 1")
    public void partitionResultTest1() {
        Integer[] arr = {8, 16, 19, 3, 4, 17, 15, 2, 5, 10, 14};
        PartitionOutput output = Partition.calculateWithOutput(arr);

        assertArrayEquals(output.getStates().get(5 - 1).getArr(), new Integer[]{8, 3, 4, 2, 5, 10, 15, 16, 19, 17, 14});
        assertNotEquals(output. getStates().get(4 - 1).getR(), 6);
        assertEquals(output. getStates().get(4 - 1).getL(), 4);
    }

    @Test
    @DisplayName("Partition PJATK Result Test 2")
    public void partitionResultTest2() {
        Integer[] arr = {2,12,14,17,16,18,6,0,11,1,13};
        PartitionOutput output = Partition.calculateWithOutput(arr);

        assertEquals(output. getStates().get(4 - 1).getComparisonsCount(), 10);
        assertEquals(output. getStates().get(4 - 1).getL(), 5);
        assertArrayEquals(output. getStates().get(4 - 1).getArr(), new Integer[]{2,12,6,0,11,1,14,17,16,18,13});
    }

    @Test
    @DisplayName("Partition PJATK Result Test 3")
    public void partitionResultTest3() {
        Integer[] arr = {5,9,13,3,8,10,11,16,1,19,12};
        PartitionOutput output = Partition.calculateWithOutput(arr);

        assertEquals(output. getStates().get(5 - 1).getR(), 9);
        assertNotEquals(output. getStates().get(5 - 1).getL(), 5);
        assertArrayNotEquals(output. getStates().get(5 - 1).getArr(), new Integer[]{5,9,3,19,10,11,1,16,13,8,12});
    }

    @Test
    @DisplayName("Partition PJATK Result Test 4")
    public void partitionResultTest4() {
        Integer[] arr = {13,5,17,8,4,12,11,16,15,18,14};
        PartitionOutput output = Partition.calculateWithOutput(arr);

        assertEquals(output. getStates().get(4 - 1).getComparisonsCount(), 7);
        assertEquals(output. getStates().get(4 - 1).getL(), 5);
        assertArrayEquals(output. getStates().get(4 - 1).getArr(), new Integer[]{13,5,8,4,12,11,17,16,15,18,14});
    }

    @Test
    @DisplayName("Partition PJATK Result Test 5")
    public void partitionResultTest5() {
        Integer[] arr = {11,3,17,16,6,4,13,0,7,1,14};
        PartitionOutput output = Partition.calculateWithOutput(arr);

        assertEquals(output. getStates().get(3 - 1).getR(), 7);
        assertEquals(output. getStates().get(6 - 1).getComparisonsCount(), 10);
        assertNotEquals(output. getStates().get(5 - 1).getR(), 8);
    }

    @Test
    @DisplayName("Partition PJATK Result Test 6")
    public void partitionResultTest6() {
        Integer[] arr = {5,10,19,15,7,6,2,13,17,9,12};
        PartitionOutput output = Partition.calculateWithOutput(arr);

        assertNotEquals(output. getStates().get(4 - 1).getL(), 7);
        assertArrayEquals(output. getStates().get(4 - 1).getArr(), new Integer[]{5,10,7,6,2,9,19,13,17,15,12});
        assertNotEquals(output. getStates().get(4 - 1).getComparisonsCount(), 9);
    }

    @Test
    @DisplayName("Partition PJATK Result Test 7")
    public void partitionResultTest7() {
        Integer[] arr = {19,2,0,17,15,6,16,1,4,9,10};
        PartitionOutput output = Partition.calculateWithOutput(arr);

        assertEquals(output. getStates().get(6 - 1).getR(), 10);
        assertEquals(output. getStates().get(6 - 1).getL(), 5);
        assertNotEquals(output. getStates().get(6 - 1).getComparisonsCount(), 9);
    }

    @Test
    @DisplayName("Partition PJATK Result Test 8")
    public void partitionResultTest8() {
        Integer[] arr = {13,6,15,9,0,14,8,19,17,16,11};
        PartitionOutput output = Partition.calculateWithOutput(arr);

        assertArrayEquals(output. getStates().get(4 - 1).getArr(), new Integer[]{6,9,0,8,15,14,13,19,17,16,11});
        assertEquals(output. getStates().get(4 - 1).getComparisonsCount(), 7);
        assertArrayNotEquals(output. getStates().get(4 - 1).getArr(), new Integer[]{19,9,0,8,15,14,13,6,17,16,11});
    }

    @Test
    @DisplayName("Partition PJATK Result Test 9")
    public void partitionResultTest9() {
        Integer[] arr = {13,18,16,19,0,1,17,2,11,3,12};
        PartitionOutput output = Partition.calculateWithOutput(arr);

        assertEquals(output. getStates().get(5 - 1).getL(), 4);
        assertArrayEquals(output. getStates().get(5 - 1).getArr(), new Integer[]{0,1,2,11,3,18,17,16,19,13,12});
        assertEquals(output. getStates().get(5 - 1).getComparisonsCount(), 10);
    }

    @Test
    @DisplayName("Partition PJATK Result Test 10")
    public void partitionResultTest10() {
        Integer[] arr = {3,9,17,7,4,16,1,10,12,13,15};
        PartitionOutput output = Partition.calculateWithOutput(arr);

        assertEquals(output. getStates().get(5 - 1).getComparisonsCount(), 9);
        assertEquals(output. getStates().get(6 - 1).getL(), 7);
        assertEquals(output. getStates().get(6 - 1).getR(), 10);
    }

    @Test
    @DisplayName("Partition PJATK Result Test 11")
    public void partitionResultTest11() {
        Integer[] arr = {17,0,1,4,2,11,3,19,8,16,6};
        PartitionOutput output = Partition.calculateWithOutput(arr);

        assertArrayEquals(output. getStates().get(5 - 1).getArr(), new Integer[]{0,1,4,2,3,11,17,19,8,16,6});
        assertEquals(output. getStates().get(5 - 1).getComparisonsCount(), 7);
        assertEquals(output. getStates().get(5 - 1).getL(), 4);
    }

    @Test
    @DisplayName("Partition PJATK Result Test 12")
    public void partitionResultTest12() {
        Integer[] arr = {9,11,19,16,17,2,3,4,10,6,7};
        PartitionOutput output = Partition.calculateWithOutput(arr);

        assertArrayEquals(output. getStates().get(4 - 1).getArr(), new Integer[]{2,3,4,6,17,9,11,19,10,16,7});
        assertNotEquals(output. getStates().get(3 - 1).getComparisonsCount(), 7);
        assertEquals(output. getStates().get(4 - 1).getComparisonsCount(), 10);
    }

    @Test
    @DisplayName("Partition PJATK Result Test 13")
    public void partitionResultTest13() {
        Integer[] arr = {15,5,4,18,13,7,9,8,0,12,16};
        PartitionOutput output = Partition.calculateWithOutput(arr);

        assertArrayEquals(output. getStates().get(6 - 1).getArr(), new Integer[]{15,5,4,13,7,9,8,0,12,18,16});
        assertNotEquals(output. getStates().get(6 - 1).getL(), 9);
        assertEquals(output. getStates().get(6 - 1).getR(), 10);
    }


    @Test
    @DisplayName("Partition PJATK Result Test 14")
    public void partitionResultTest14() {
        Integer[] arr = {7,12,16,15,3,2,0,6,5,4,11};
        PartitionOutput output = Partition.calculateWithOutput(arr);

        assertArrayNotEquals(output. getStates().get(6 - 1).getArr(), new Integer[]{7,3,5,0,6,2,4,12,16,15,11});
        assertEquals(output. getStates().get(6 - 1).getL(), 6);
        assertEquals(output. getStates().get(6 - 1).getR(), 10);
    }

    @Test
    @DisplayName("Partition PJATK Result Test 15")
    public void partitionResultTest15() {
        Integer[] arr = {7,6,12,3,4,9,5,18,13,8,10};
        PartitionOutput output = Partition.calculateWithOutput(arr);

        assertEquals(output. getStates().get(4 - 1).getR(), 7);
        assertEquals(output. getStates().get(4 - 1).getL(), 5);
        assertNotEquals(output. getStates().get(5 - 1).getL(), 8);
    }

    @Test
    @DisplayName("Partition PJATK Result Test 16")
    public void partitionResultTest16() {
        Integer[] arr = {0,14,8,1,13,6,5,18,4,16,7};
        PartitionOutput output = Partition.calculateWithOutput(arr);

        assertNotEquals(output. getStates().get(3 - 1).getR(), 8);
        assertNotEquals(output. getStates().get(4 - 1).getL(), 5);
        assertEquals(output. getStates().get(4 - 1).getL(), 4);
    }
}
