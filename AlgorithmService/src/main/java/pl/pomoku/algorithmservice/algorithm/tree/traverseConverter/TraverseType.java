package pl.pomoku.algorithmservice.algorithm.tree.traverseConverter;

import lombok.AllArgsConstructor;
import pl.pomoku.algorithmservice.algorithm.tree.Node;

@AllArgsConstructor
public enum TraverseType implements TraverseTypeAction<Integer> {
    PRE {
        @Override
        public Node<Integer> build(Integer[] array) {
            return buildTreeFromPreOrder(array, new int[]{0}, 0, array.length - 1);
        }

        @Override
        public Integer[] traverse(Node<Integer> node) {
            Integer[] result = new Integer[getSize(node)];
            fillPreOrder(node, result, new int[]{0});
            return result;
        }

        private void fillPreOrder(Node<Integer> node, Integer[] array, int[] index) {
            if (node == null) {
                return;
            }
            array[index[0]++] = node.getData();
            fillPreOrder(node.getLeft(), array, index);
            fillPreOrder(node.getRight(), array, index);
        }

        private Node<Integer> buildTreeFromPreOrder(Integer[] preOrder, int[] preIndex, int start, int end) {
            if (start > end) return null;

            Node<Integer> root = new Node<>(preOrder[preIndex[0]++]);
            if (start == end) return root;

            int leftSubtreeEnd = start + 1 + (end - start) / 2;
            root.setLeft(buildTreeFromPreOrder(preOrder, preIndex, start + 1, leftSubtreeEnd - 1));
            root.setRight(buildTreeFromPreOrder(preOrder, preIndex, leftSubtreeEnd, end));
            return root;
        }
    },
    POST {
        @Override
        public Node<Integer> build(Integer[] array) {
            return buildTreeFromPostOrder(array, new int[]{array.length - 1}, 0, array.length - 1);
        }

        @Override
        public Integer[] traverse(Node<Integer> node) {
            Integer[] result = new Integer[getSize(node)];
            fillPostOrder(node, result, new int[]{0});
            return result;
        }

        private void fillPostOrder(Node<Integer> node, Integer[] array, int[] index) {
            if (node == null) {
                return;
            }
            fillPostOrder(node.getLeft(), array, index);
            fillPostOrder(node.getRight(), array, index);
            array[index[0]++] = node.getData();
        }

        private Node<Integer> buildTreeFromPostOrder(Integer[] postOrder, int[] postIndex, int start, int end) {
            if (start > end) return null;

            Node<Integer> root = new Node<Integer>(postOrder[postIndex[0]--]);
            if (start == end) return root;

            int rightSubtreeStart = start + (end - start) / 2;
            root.setRight(buildTreeFromPostOrder(postOrder, postIndex, rightSubtreeStart + 1, end - 1));
            root.setLeft(buildTreeFromPostOrder(postOrder, postIndex, start, rightSubtreeStart));
            return root;
        }
    },
    IN {
        @Override
        public Node<Integer> build(Integer[] array) {
            return buildTreeFromInOrder(array, 0, array.length - 1);
        }

        @Override
        public Integer[] traverse(Node<Integer> node) {
            Integer[] result = new Integer[getSize(node)];
            fillInOrder(node, result, new int[]{0});
            return result;
        }

        private void fillInOrder(Node<Integer> node, Integer[] array, int[] index) {
            if (node == null) {
                return;
            }
            fillInOrder(node.getLeft(), array, index);
            array[index[0]++] = node.getData();
            fillInOrder(node.getRight(), array, index);
        }

        private Node<Integer> buildTreeFromInOrder(Integer[] inOrder, int start, int end) {
            if (start > end) return null;

            int mid = start + (end - start) / 2;
            Node<Integer> root = new Node<Integer>(inOrder[mid]);

            root.setLeft(buildTreeFromInOrder(inOrder, start, mid - 1));
            root.setRight(buildTreeFromInOrder(inOrder, mid + 1, end));
            return root;
        }
    };

    private static int getSize(Node<Integer> node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSize(node.getLeft()) + getSize(node.getRight());
    }
}
