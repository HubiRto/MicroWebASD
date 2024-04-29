package pl.pomoku.algorithmservice.dto.output;

import pl.pomoku.algorithmservice.model.PartitionState;

import java.util.List;

public record PartitionOutput(int result, List<PartitionState> states) {}
