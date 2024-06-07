package pl.pomoku.algorithmservice.algorithm.tree;

import lombok.*;
import org.springframework.data.annotation.Transient;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> left;
    private Node<T> right;
    @Transient
    private Integer level = 0;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, int level) {
        this.data = data;
        this.level = level;
    }

    @SuppressWarnings("unused")
    public void print() {
        print("", this, false);
    }

    private void print(String prefix, Node<T> node, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getData());
            print(prefix + (isLeft ? "│   " : "    "), node.left, true);
            print(prefix + (isLeft ? "│   " : "    "), node.right, false);
        }
    }
}
