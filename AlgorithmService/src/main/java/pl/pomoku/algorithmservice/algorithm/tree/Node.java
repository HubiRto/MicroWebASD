package pl.pomoku.algorithmservice.algorithm.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Node {
    private Integer value;
    private Node left;
    private Node right;
    private Integer level = 0;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, int level) {
        this.value = value;
        this.level = level;
    }

    @SuppressWarnings("unused")
    public void print() {
        print("", this, false);
    }

    private void print(String prefix, Node node, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getValue());
            print(prefix + (isLeft ? "│   " : "    "), node.left, true);
            print(prefix + (isLeft ? "│   " : "    "), node.right, false);
        }
    }
}
