package solutions;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTree {
    private int value;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(int key, BinaryTree first, BinaryTree second) {
        this.value = key;
        this.left = first;
        this.right = second;
    }

    public Integer findLowestCommonAncestor(int first, int second) {
        List<Integer> firstPath = findPath(first);
        List<Integer> secondPath = findPath(first);

        int smallerPath = Math.min(firstPath.size(), secondPath.size());

        int i = 0;
        for (; i < smallerPath; i++) {
            if (!firstPath.get(i).equals(secondPath.get(i))) {
                break;
            }
        }

        return firstPath.get(i - 1);
    }

    private List<Integer> findPath(int element) {
        List<Integer> result = new ArrayList<>();

        findNodePath(this, element, result);

        return result;
    }

    private boolean findNodePath(BinaryTree binaryTree, int element, List<Integer> currentPath) {
        if (binaryTree == null) {
            return false;
        }

        if (binaryTree.value == element) {
            return true;
        }

        currentPath.add(binaryTree.value);

        boolean left = findNodePath(binaryTree.left, element, currentPath);
        if (left) {
            return true;
        }

        boolean right = findNodePath(binaryTree.right, element, currentPath);

        if (right) {
            return true;
        }

        currentPath.remove(Integer.valueOf(binaryTree.value));
        return false;
    }

    // TOP VIEW
    public List<Integer> topView() {
        Map<Integer, Pair<Integer, Integer>> offsetToValueLevel = new TreeMap<>();

        traverseTree(this, 0, 1, offsetToValueLevel);

       return offsetToValueLevel
               .values()
                .stream()
                .map(Pair::getKey)
                .collect(Collectors.toList());
    }

    private void traverseTree(BinaryTree tree, int offset, int level, Map<Integer, Pair<Integer, Integer>> offsetToValueLevel) {
        if (tree == null) {
            return;
        }

        Pair<Integer, Integer> currentValueLevel = offsetToValueLevel.get(offset);

        if (currentValueLevel == null || level < currentValueLevel.getValue()) {
            offsetToValueLevel.put(offset, new Pair<>(tree.value, level));
        }

        traverseTree(tree.left, offset - 1, level + 1, offsetToValueLevel);
        traverseTree(tree.right, offset + 1, level + 1, offsetToValueLevel);
    }
}
