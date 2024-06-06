package pl.pomoku.algorithmservice.algorithm.tree.traverseConverter;

import pl.pomoku.algorithmservice.dto.input.TraverseConverterInput;
import pl.pomoku.algorithmservice.dto.output.TraverseConverterOutput;

public class TraverseConverter {

    public static TraverseConverterOutput convert(TraverseConverterInput input) {
        return new TraverseConverterOutput(convert(input.getArr(), input.getFrom(), input.getTo()));
    }

    public static int[] convert(Integer[] array, TraverseType from, TraverseType to) {
        return to.traverse(from.build(array));
    }
}
