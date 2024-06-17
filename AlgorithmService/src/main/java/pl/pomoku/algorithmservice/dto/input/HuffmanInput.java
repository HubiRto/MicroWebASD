package pl.pomoku.algorithmservice.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class HuffmanInput {
    private Map<Character, Integer> charFreqMap;
}
