package pl.pomoku.algorithmservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PartitionState {
    private Integer[] arr;
    private int l;
    private int r;
    private int comparisonsCount;
}
