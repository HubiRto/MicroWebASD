package pl.pomoku.algorithmservice.dto.output;

import java.util.List;


public record BinSearchOutput(List<Integer> mArr, int comparisonsCount, int result) {}
