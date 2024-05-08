package pl.pomoku.algorithmservice.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepthFirstSearchOutput extends AbstractCalculationTime<DepthFirstSearchOutput> {
    private Map<Integer, List<Integer>> paths;
    private int pushOperationCount;
    private int popOperationCount;
    private int externalCount;
    private int internalCount;
    private int maxDepth;
    private int maxStackSize;
    private List<Integer> traverse;

    public void printSummary() {
        System.out.println("-------------------------------");
        System.out.println("DFS Summary Report:");
        System.out.println("-------------------------------");
        System.out.println("Push Operations: " + pushOperationCount);
        System.out.println("Pop Operations: " + popOperationCount);
        System.out.println("Maximum Stack Size: " + maxStackSize);
        System.out.println("Maximum Depth: " + maxDepth);
        System.out.println("External Vertices: " + externalCount);
        System.out.println("Internal Vertices: " + internalCount);
        System.out.println("Traverse Order: " + traverse.stream().map(Object::toString).collect(Collectors.joining(", ")));
        System.out.println("-------------------------------");
        System.out.println("Paths from Start Vertex:");
        paths.forEach((key, value) -> System.out.println("To Vertex " + key + ": " + value.stream().map(Object::toString).collect(Collectors.joining(" -> "))));
        System.out.println("-------------------------------");
    }

    @Override
    protected DepthFirstSearchOutput getOutput() {
        return this;
    }
}
