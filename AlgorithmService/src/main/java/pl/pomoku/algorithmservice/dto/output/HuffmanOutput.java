package pl.pomoku.algorithmservice.dto.output;

import lombok.*;
import pl.pomoku.algorithmservice.model.AbstractCalculationTime;

import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HuffmanOutput extends AbstractCalculationTime<HuffmanOutput> {
    private Map<String, String> codes;
    private int treeHeight;
    private String leafLabels;

    @Override
    protected HuffmanOutput getOutput() {
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Huffman Codes:\n");
        for (Map.Entry<String, String> codeEntry : codes.entrySet()) {
            sb.append(codeEntry.getKey()).append(": ").append(codeEntry.getValue()).append("\n");
        }
        sb.append("\nTree Height: ").append(treeHeight).append("\n");
        sb.append("Leaf Labels: ").append(leafLabels).append("\n\n");
        return sb.toString();
    }
}
