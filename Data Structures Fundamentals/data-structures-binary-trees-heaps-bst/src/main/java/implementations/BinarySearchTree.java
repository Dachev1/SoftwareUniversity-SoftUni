package implementations;

import interfaces.AbstractBinarySearchTree;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    private Node<E> root;
    private Node<E> left;
    private Node<E> right;

    public BinarySearchTree() {}

    public BinarySearchTree(Node<E> root) {
        this.copy (root);
    }

    private void copy(Node<E> node) {
        if (node == null) {
            return;
        }

        this.insert(node.value);
        this.copy(node.leftChild);
        this.copy(node.rightChild);
    }

    @Override
    public void insert(E element) {
        Node<E> newNode = new Node<>(element);

        if (this.getRoot() == null) {
            this.root = newNode;
        } else  {
            Node<E> current = this.root;
            Node<E> prev = current;

            while (current != null) {
                prev = current;
                if (isLess(element, current.value)) {
                    current = current.leftChild;
                } else if (isGreater(element, current.value)) {
                    current = current.rightChild;
                } else {
                    return;
                }
            }

            if (isLess(element, prev.value)) {
                prev.leftChild = newNode;
            } else if (isGreater(element, prev.value)) {
                prev.rightChild = newNode;
            }
        }
    }

    @Override
    public boolean contains(E element) {
        Node<E> current = this.root;

        while (current != null) {
            if (isLess(element, current.value)) {
                current = current.leftChild;
            } else if (isGreater(element, current.value)) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        AbstractBinarySearchTree<E> result = new BinarySearchTree<>();

        Node<E> current = this.root;

        while (current != null) {
            if (isLess(element, current.value)) {
                current = current.leftChild;
            } else if (isGreater(element, current.value)) {
                current = current.rightChild;
            } else {
                return new BinarySearchTree<>(current);
            }
        }
        return result;
    }

    @Override
    public Node<E> getRoot() {
        return this.root;
    }

    @Override
    public Node<E> getLeft() {
        return this.left;
    }

    @Override
    public Node<E> getRight() {
        return this.right;
    }

    @Override
    public E getValue() {
        return this.root.value;
    }

    private boolean isLess(E first, E second) {
        return first.compareTo(second) < 0;
    }

    private boolean isGreater(E first, E second) {
        return first.compareTo(second) > 0;
    }
}