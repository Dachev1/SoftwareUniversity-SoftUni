package implementations;

import interfaces.AbstractTree;

import java.util.*;

public class Tree<E> implements AbstractTree<E> {
    private E value;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E value, Tree<E>... subtrees) {
        this.value = value;
        this.parent = null;
        this.children = new ArrayList<>();

        for (Tree<E> subtree : subtrees) {
            this.children.add(subtree);
            subtree.parent = this;
        }

    }

    @Override
    public List<E> orderBfs() {
        List<E> result = new ArrayList<>();

        if (this.value == null) {
            return result;
        }

        Deque<Tree<E>> queue = new ArrayDeque<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            Tree<E> getCurrentChild = queue.poll();

            result.add(getCurrentChild.value);

            for (Tree<E> child : getCurrentChild.children) {
                queue.offer(child);
            }
        }

        return result;
    }

    @Override
    public List<E> orderDfs() {
        List<E> result = new ArrayList<>();

        if (this.value == null) {
            return result;
        }

        this.dfs(this, result);
        return result;
    }

    @Override
    public void addChild(E parentKey, Tree<E> child) {
        Tree<E> root = search(parentKey);

        if (root == null) {
            throw new NullPointerException();
        }

        root.children.add(child);
    }

    @Override
    public void removeNode(E nodeKey) {
        Tree<E> toRemove = search(nodeKey);

        if (toRemove == null) {
            throw new NullPointerException();
        }

        for (Tree<E> child : toRemove.children) {
            child.parent = null;
        }

        toRemove.children.clear();

        Tree<E> parent = toRemove.parent;

        if (parent != null) {
            parent.children.remove(toRemove);
        }

        toRemove.value = null;
    }

    @Override
    public void swap(E firstKey, E secondKey) {
        Tree<E> firstNode = search(firstKey);
        Tree<E> secondNode = search(secondKey);

        if (firstNode == null || secondNode == null) {
            throw new NullPointerException();
        }

        Tree<E> firstParent = firstNode.parent;
        Tree<E> secondParent = secondNode.parent;

        if (firstParent == null) {
            this.value = secondNode.value;
            this.parent = null;
            this.children = secondNode.children;
            return;
        } else if (secondParent == null){
            this.value = firstNode.value;
            this.parent = null;
            this.children = firstNode.children;
            return;
        }

        firstNode.parent = secondParent;
        secondNode.parent = firstParent;

        int firstIndex = firstParent.children.indexOf(firstNode);
        int secondIndex = secondParent.children.indexOf(secondNode);

        firstParent.children.set(firstIndex, secondNode);
        secondParent.children.set(secondIndex, firstNode);

    }

    private void dfs(Tree<E> node, List<E> result) {
        for (Tree<E> child : node.children) {
            this.dfs(child, result);
        }

        result.add(node.value);
    }

    private Tree<E> search(E node) {
        Deque<Tree<E>> queue = new ArrayDeque<>();

        queue.offer(this);

        while (!queue.isEmpty()) {
            Tree<E> getCurrentChild = queue.poll();

            if (getCurrentChild.value.equals(node)) {
                return getCurrentChild;
            }

            for (Tree<E> child : getCurrentChild.children) {
                queue.offer(child);
            }
        }

        return null;
    }
}



