package pl.pomoku.algorithmservice.dto.output;

import lombok.*;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;
import pl.pomoku.algorithmservice.model.Vertex;
import pl.pomoku.algorithmservice.model.deque.CounterDeque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FirstSearchOutput extends AbstractCalculationTime<FirstSearchOutput> {
    private Map<Integer, List<Integer>> paths = new HashMap<>();
    private int inOperationCount;
    private int outOperationCount;
    private int externalCount = 0;
    private int internalCount = 0;
    private int maxDepth = 0;
    private int maxDequeSize;
    private List<Integer> traverse = new ArrayList<>();

    @Override
    protected FirstSearchOutput getOutput() {
        return this;
    }

    public void addDeque(CounterDeque<Vertex<Integer>> deque){
        this.maxDequeSize = deque.maxSize();
        this.inOperationCount = deque.inOperationCount();
        this.outOperationCount = deque.outOperationCount();
    }

    public void increaseExternal() {
        this.externalCount++;
    }

    public void increaseInternal() {
        this.internalCount++;
    }

    public void setMaxDepth(int currentDepth) {
        this.maxDepth = Math.max(this.maxDepth, currentDepth);
    }
}
