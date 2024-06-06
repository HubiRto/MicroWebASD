package pl.pomoku.algorithmservice.model;

import lombok.*;
import pl.pomoku.algorithmservice.algorithm.tree.Node;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TreeCheckerStep {
    private Integer removedLevel;
    private Node tree;
    private boolean isFull;
    private boolean isRegular;
    private boolean isRightComplete;
    private boolean isLeftComplete;
}
