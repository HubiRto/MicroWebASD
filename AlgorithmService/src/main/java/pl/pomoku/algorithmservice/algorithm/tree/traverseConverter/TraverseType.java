package pl.pomoku.algorithmservice.algorithm.tree.traverseConverter;

import lombok.AllArgsConstructor;
import pl.pomoku.algorithmservice.algorithm.tree.Node;

@AllArgsConstructor
public enum TraverseType implements TraverseTypeAction {
    PRE {
        @Override
        public Node build(Integer[] array) {
            return buildTreeFromPreOrder(array, new int[]{0}, 0, array.length - 1);
        }

        @Override
        public int[] traverse(Node node) {
            int[] result = new int[getSize(node)];
            fillPreOrder(node, result, new int[]{0});
            return result;
        }

        private void fillPreOrder(Node node, int[] array, int[] index) {
            if (node == null) {
                return;
            }
            array[index[0]++] = node.getValue();
            fillPreOrder(node.getLeft(), array, index);
            fillPreOrder(node.getRight(), array, index);
        }

        private Node buildTreeFromPreOrder(Integer[] preOrder, int[] preIndex, int start, int end) {
            if (start > end) return null;

            Node root = new Node(preOrder[preIndex[0]++]);
            if (start == end) return root;

            int leftSubtreeEnd = start + 1 + (end - start) / 2;
            root.setLeft(buildTreeFromPreOrder(preOrder, preIndex, start + 1, leftSubtreeEnd - 1));
            root.setRight(buildTreeFromPreOrder(preOrder, preIndex, leftSubtreeEnd, end));
            return root;
        }
    },
    POST {
        @Override
        public Node build(Integer[] array) {
            return buildTreeFromPostOrder(array, new int[]{array.length - 1}, 0, array.length - 1);
        }

        @Override
        public int[] traverse(Node node) {
            int[] result = new int[getSize(node)];
            fillPostOrder(node, result, new int[]{0});
            return result;
        }

        private void fillPostOrder(Node node, int[] array, int[] index) {
            if (node == null) {
                return;
            }
            fillPostOrder(node.getLeft(), array, index);
            fillPostOrder(node.getRight(), array, index);
            array[index[0]++] = node.getValue();
        }

        private Node buildTreeFromPostOrder(Integer[] postOrder, int[] postIndex, int start, int end) {
            if (start > end) return null;

            Node root = new Node(postOrder[postIndex[0]--]);
            if (start == end) return root;

            int rightSubtreeStart = start + (end - start) / 2;
            root.setRight(buildTreeFromPostOrder(postOrder, postIndex, rightSubtreeStart + 1, end - 1));
            root.setLeft(buildTreeFromPostOrder(postOrder, postIndex, start, rightSubtreeStart));
            return root;
        }
    },
    IN {
        @Override
        public Node build(Integer[] array) {
            return buildTreeFromInOrder(array, 0, array.length - 1);
        }

        @Override
        public int[] traverse(Node node) {
            int[] result = new int[getSize(node)];
            fillInOrder(node, result, new int[]{0});
            return result;
        }

        private void fillInOrder(Node node, int[] array, int[] index) {
            if (node == null) {
                return;
            }
            fillInOrder(node.getLeft(), array, index);
            array[index[0]++] = node.getValue();
            fillInOrder(node.getRight(), array, index);
        }

        private Node buildTreeFromInOrder(Integer[] inOrder, int start, int end) {
            if (start > end) return null;

            int mid = start + (end - start) / 2;
            Node root = new Node(inOrder[mid]);

            root.setLeft(buildTreeFromInOrder(inOrder, start, mid - 1));
            root.setRight(buildTreeFromInOrder(inOrder, mid + 1, end));
            return root;
        }
    };

    private static int getSize(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSize(node.getLeft()) + getSize(node.getRight());
    }
}
