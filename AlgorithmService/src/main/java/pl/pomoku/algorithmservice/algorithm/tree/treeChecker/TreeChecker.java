package pl.pomoku.algorithmservice.algorithm.tree.treeChecker;

import lombok.Getter;
import pl.pomoku.algorithmservice.algorithm.tree.Node;
import pl.pomoku.algorithmservice.dto.output.TreeCheckerOutput;
import pl.pomoku.algorithmservice.exception.InvalidNodePathException;
import pl.pomoku.algorithmservice.model.TreeCheckerStep;

import java.util.*;

@Getter
public class TreeChecker {
    private Node<Integer> root;
    private int maxLevel = 0;

    public TreeChecker(String data) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Data is null or empty");
        }

        String[] nodes = data.split(" ");
        if (nodes.length == 0) {
            throw new IllegalArgumentException("Data is null or empty");
        }

        for (String nodeData : nodes) {
            int valueIndex = 0;
            while (valueIndex < nodeData.length() && Character.isDigit(nodeData.charAt(valueIndex))) {
                valueIndex++;
            }
            int value = Integer.parseInt(nodeData.substring(0, valueIndex));
            String path = nodeData.substring(valueIndex);
            insertNode(value, path);
        }
        assignLevels(this.root);
    }

    private void insertNode(int value, String path) {
        if (path.equals("RT")) {
            this.root = new Node<>(value);
            return;
        }

        if (path.length() - 1 > maxLevel) {
            maxLevel = path.length();
        }

        Node<Integer> current = this.root;
        for (int i = 0; i < path.length() - 1; i++) {
            if (current == null) {
                throw new InvalidNodePathException("Parent node does not exist for path: " + path);
            }
            if (path.charAt(i) == 'L') {
                current = current.getLeft();
            } else if (path.charAt(i) == 'R') {
                current = current.getRight();
            }
        }

        if (current == null) {
            throw new InvalidNodePathException("Parent node does not exist for path: " + path);
        }

        if (path.charAt(path.length() - 1) == 'L') {
            if (current.getLeft() != null) {
                throw new IllegalArgumentException("Node already exists on path: " + path);
            }
            current.setLeft(new Node<>(value, path.length() - 1));
        } else if (path.charAt(path.length() - 1) == 'R') {
            if (current.getRight() != null) {
                throw new IllegalArgumentException("Node already exists on path: " + path);
            }
            current.setRight(new Node<>(value, path.length() - 1));
        }
    }

    public TreeChecker(Node<Integer> root) {
        this.root = root;
        assignLevels(this.root);
    }

    private void assignLevels(Node<Integer> root) {
        if (root.getLeft() != null) {
            root.getLeft().setLevel(root.getLevel() + 1);
            if (root.getLeft().getLevel() > maxLevel) {
                maxLevel = root.getLeft().getLevel();
            }
            assignLevels(root.getLeft());
        }

        if (root.getRight() != null) {
            root.getRight().setLevel(root.getLevel() + 1);
            if (root.getRight().getLevel() > maxLevel) {
                maxLevel = root.getRight().getLevel();
            }
            assignLevels(root.getRight());
        }
    }


    public TreeCheckerOutput calculate() {
        TreeCheckerOutput output = new TreeCheckerOutput();
        output.setHeight(maxLevel);

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<Integer> current = queue.poll();
            if (current.getLeft() == null && current.getRight() == null) {
                output.setExternalEdges(output.getExternalEdges() + 1);
            } else {
                if (current.getLeft() != null) queue.add(current.getLeft());
                if (current.getRight() != null) queue.add(current.getRight());
                output.setInternalEdges(output.getInternalEdges() + 1);
            }
        }

        List<TreeCheckerStep> steps = new ArrayList<>();
        steps.add(new TreeCheckerStep(null, copyTree(root), isFullBinaryTree(), isCompleteBinaryTree(), isRightCompleteBinaryTree(), isLeftCompleteBinaryTree()));

        for (int i = 0; i <= maxLevel - 1; i++) {
            removeLastLevel(root, maxLevel - i);
            steps.add(new TreeCheckerStep(maxLevel - i, copyTree(root), isFullBinaryTree(), isCompleteBinaryTree(), isRightCompleteBinaryTree(), isLeftCompleteBinaryTree()));
        }

        output.setSteps(steps);
        return output;
    }

    private static Node<Integer> copyTree(Node<Integer> root) {
        if (root == null) {
            return null;
        }
        Node<Integer> newNode = new Node<>(root.getData());
        newNode.setLevel(root.getLevel());
        newNode.setLeft(copyTree(root.getLeft()));
        newNode.setRight(copyTree(root.getRight()));

        return newNode;
    }

    private boolean isFullBinaryTree() {
        return isFullBinaryTree(this.root);
    }

    private boolean isFullBinaryTree(Node<Integer> node) {
        if (node == null) return true;
        if (node.getLeft() == null && node.getRight() == null) return true;
        if (node.getLeft() != null && node.getRight() != null) {
            return isFullBinaryTree(node.getLeft()) && isFullBinaryTree(node.getRight());
        }
        return false;
    }

    private boolean isCompleteBinaryTree() {
        return isCompleteBinaryTree(this.root);
    }

    private boolean isCompleteBinaryTree(Node<Integer> node) {
        if (node == null) return true;

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(node);
        boolean flag = false;

        while (!queue.isEmpty()) {
            Node<Integer> temp = queue.poll();

            if (temp.getLeft() != null) {
                if (flag) return false;
                queue.add(temp.getLeft());
            } else {
                flag = true;
            }

            if (temp.getRight() != null) {
                if (flag) return false;
                queue.add(temp.getRight());
            } else {
                flag = true;
            }
        }

        return true;
    }

    private boolean isLeftCompleteBinaryTree() {
        return isLeftCompleteBinaryTree(this.root);
    }

    private boolean isLeftCompleteBinaryTree(Node<Integer> node) {
        if (node == null) return true;

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(node);
        boolean end = false;

        while (!queue.isEmpty()) {
            Node<Integer> temp = queue.poll();

            if (temp.getLeft() != null) {
                if (end) return false;
                queue.add(temp.getLeft());
            } else {
                end = true;
            }

            if (temp.getRight() != null) {
                if (end) return false;
                queue.add(temp.getRight());
            } else {
                end = true;
            }
        }
        return true;
    }

    private boolean isRightCompleteBinaryTree() {
        return isRightCompleteBinaryTree(this.root);
    }

    private boolean isRightCompleteBinaryTree(Node<Integer> node) {
        if (node == null) return true;

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(node);
        boolean foundIncomplete = false;

        while (!queue.isEmpty()) {
            Node<Integer> current = queue.poll();

            if (current.getRight() != null) {
                if (foundIncomplete) return false;
                queue.add(current.getRight());
            } else {
                foundIncomplete = true;
            }

            if (current.getLeft() != null) {
                if (foundIncomplete) return false;
                queue.add(current.getLeft());
            } else {
                foundIncomplete = true;
            }
        }

        return true;
    }

    private void removeLastLevel(Node<Integer> root, int level) {
        if (root == null) return;

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<Integer> temp = queue.poll();

            if (temp.getLeft() != null) {
                if (temp.getLeft().getLevel() == level) {
                    temp.setLeft(null);
                } else {
                    queue.add(temp.getLeft());
                }
            }

            if (temp.getRight() != null) {
                if (temp.getRight().getLevel() == level) {
                    temp.setRight(null);
                } else {
                    queue.add(temp.getRight());
                }
            }
        }
    }
}
