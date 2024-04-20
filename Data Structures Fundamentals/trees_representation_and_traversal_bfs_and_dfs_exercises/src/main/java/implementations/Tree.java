package implementations;

import interfaces.AbstractTree;

import java.util.*;

public class Tree<E> implements AbstractTree<E> {
    private E key;
    private Tree<E> parent;
    private List<Tree<E>> children;
    private Tree<E> c;

    public Tree(E key) {
        this.key = key;
        this.children = new ArrayList<>();
    }

    @Override
    public void setParent(Tree<E> parent) {
        this.parent = parent;
    }

    @Override
    public void addChild(Tree<E> child) {
        this.children.add(child);
    }

    @Override
    public Tree<E> getParent() {
        return this.parent;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public String getAsString() {
        StringBuilder builder = new StringBuilder();

        getTreeAsString(builder, this, 0);

        return builder.toString().trim();
    }

    @Override
    public List<E> getLeafKeys() {
        return getLeafs();
    }

    @Override
    public List<E> getMiddleKeys() {
        return getMiddleNodes();
    }

    @Override
    public Tree<E> getDeepestLeftmostNode() {
        return getDeepestNode();
    }

    @Override
    public List<E> getLongestPath() {
        List<E> path = new ArrayList<>();

        Tree<E> tmp = getDeepestLeftmostNode();

        while (tmp.parent != null) {
            path.add(tmp.key);
            tmp = tmp.parent;
        }

        Collections.reverse(path);

        // adding root in the beginning of the list, because every node start from the root
        path.add(0, this.key);
        return path;
    }

    @Override
    public List<List<E>> pathsWithGivenSum(int sum) {
        List<List<E>> paths = everyPath();
        List<List<E>> pathsThatEqualsSum = new ArrayList<>();

        for (List<E> path : paths) {
            int pathSum = 0;
            for (E value : path) {
                pathSum += Integer.parseInt(String.valueOf(value));

                if (pathSum == sum) {
                    pathsThatEqualsSum.add(path);
                }
            }
        }

        return pathsThatEqualsSum;
    }

    @Override
    public List<Tree<E>> subTreesWithGivenSum(int sum) {
        return getSubTrees(sum);
    }

    // private methods
    private List<Tree<E>> getEveryNode() {
        List<Tree<E>> nodes = new ArrayList<>();
        Deque<Tree<E>> queue = new ArrayDeque<>();

        queue.offer(this);

        while (!queue.isEmpty()) {
            Tree<E> currentNode = queue.poll();

            nodes.add(currentNode);

            for (Tree<E> child : currentNode.children) {
                queue.offer(child);
            }
        }

        return nodes;
    }

    private void getTreeAsString(StringBuilder builder, Tree<E> tree, int level) {

        builder.append(getRequiredSpaces(level))
                .append(tree.key)
                .append(System.lineSeparator());

        for (Tree<E> child : tree.children) {
            this.getTreeAsString(builder, child, level + 2);
        }
    }

    private StringBuilder getRequiredSpaces(int level) {
        StringBuilder builder = new StringBuilder();

        builder.append(" ".repeat(Math.max(0, level)));

        return builder;
    }

    private List<E> getLeafs() {
        List<E> leafKeys = new ArrayList<>();
        List<Tree<E>> allNodes = getEveryNode();

        for (Tree<E> currentNode : allNodes) {
            if (currentNode.children.isEmpty()) {
                leafKeys.add(currentNode.key);
            }
        }

        return leafKeys;
    }

    private List<E> getMiddleNodes() {
        List<E> middleNodes = new ArrayList<>();
        List<Tree<E>> allNodes = getEveryNode();

        for (Tree<E> currentNode : allNodes) {
            if (!currentNode.children.isEmpty() && currentNode.parent != null) {
                middleNodes.add(currentNode.key);
            }
        }

        return middleNodes;
    }

    private Tree<E> getDeepestNode() {
        List<Tree<E>> nodes = getEveryNode();

        int maxPath = 0;
        Tree<E> deepestNode = null;

        for (Tree<E> node : nodes) {
            int currentPath = getDeepestPath(node);

            if (currentPath > maxPath) {
                maxPath = currentPath;
                deepestNode = node;
            }
        }

        return deepestNode;

    }

    private int getDeepestPath(Tree<E> node) {
        int path = 0;
        Tree<E> current = node;

        while (current.parent != null) {
            path++;
            current = current.parent;
        }

        return path;
    }

    private List<List<E>> everyPath() {
        List<Tree<E>> nodes = getEveryNode();
        List<List<E>> nodePaths = new ArrayList<>();

        for (Tree<E> node : nodes) {
            List<E> path = getPath(node);
            nodePaths.add(path);
        }

        return nodePaths;
    }

    private List<E> getPath(Tree<E> node) {
        List<E> path = new ArrayList<>();

        Tree<E> current = node;
        while (current.parent != null) {
            path.add(current.key);
            current = current.parent;
        }

        Collections.reverse(path);
        path.add(0, this.key);
        return path;
    }

    private List<Tree<E>> getSubTrees(int sum) {
//        List<Tree<E>> nodes = getEveryNode();
//        List<Tree<E>> subs = new ArrayList<>();
//
//        for (Tree<E> node : nodes) {
//            if (node.parent == null) {
//                continue;
//            }
//
//            if (!node.children.isEmpty() && node.parent.key.equals(this.key)) {
//                subs.add(node);
//            }
//        }
//
//        return subs;

        List<Tree<E>> subTreesWithEqualSum = new ArrayList<>();
        Deque<Tree<E>> queue = new ArrayDeque<>();

        queue.offer(this);

        while (!queue.isEmpty()) {
            int nodeSum = 0;
            Tree<E> currentNode = queue.poll();

            nodeSum += Integer.parseInt(String.valueOf(currentNode.key));

            for (Tree<E> child : currentNode.children) {
                queue.offer(child);
                if (!child.children.isEmpty()) {
                    for (Tree<E> childChildren : child.children) {
                        nodeSum += Integer.parseInt(String.valueOf(childChildren.key));
                    }
                }
                nodeSum += Integer.parseInt(String.valueOf(child.key));
            }

            if (nodeSum == sum) {
                subTreesWithEqualSum.add(currentNode);
            }
        }

        return subTreesWithEqualSum;
    }
}



