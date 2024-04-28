import java.util.*;
import java.util.function.Consumer;

public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(E element) {
        this.root = new Node<>(element);
    }

    public BinarySearchTree(Node<E> otherRoot) {
        this.root = new Node<>(otherRoot);
    }

    public static class Node<E> {
        private final E value;
        private Node<E> leftChild;
        private Node<E> rightChild;

        public Node(E value) {
            this.value = value;
        }

        public Node(Node<E> other) {
            this.value = other.value;

            if (other.getLeft() != null) {
                this.leftChild = new Node<>(other.getLeft());
            }

            if (other.getRight() != null) {
                this.rightChild = new Node<>(other.getRight());
            }
        }

        public Node<E> getLeft() {
            return this.leftChild;
        }

        public Node<E> getRight() {
            return this.rightChild;
        }

        public E getValue() {
            return this.value;
        }
    }

    public void eachInOrder(Consumer<E> consumer) {
        this.inOrder(this.root, consumer);
    }

    public Node<E> getRoot() {
        return this.root;
    }

    public void insert(E element) {
        if (this.root == null) {
            this.root = new Node<>(element);
        } else {
            this.insertInto(this.root, element);
        }
    }

    public boolean contains(E element) {
        return containsNode(this.root, element);
    }

    public BinarySearchTree<E> search(E element) {
        Node<E> found = searchNode(this.root, element);

        return found == null ? null : new BinarySearchTree<>(found);
    }

    public List<E> range(E lower, E upper) {
        List<E> result = new ArrayList<>();

        if (this.root == null) {
            return result;
        }

        Deque<Node<E>> queue = new ArrayDeque<>();

        queue.offer(this.root);

        while (!queue.isEmpty()) {
            Node<E> current = queue.poll();

            if (current.getLeft() != null) {
                queue.offer(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.offer(current.getRight());
            }

            if (isLess(lower, current) && isGreater(upper, current)) {
                result.add(current.getValue());
            } else if (isEqual(lower, current) || isEqual(upper, current)) {
                result.add(current.getValue());
            }
        }

        return result;
    }

    public void deleteMin() {
        ensureIsNonEmpty();

        if (this.root.getLeft() == null) {
            this.root = this.root.getRight();
            return;
        }

        Node<E> current = this.root;
        while (current.getLeft().getLeft() != null) {
            current = current.getLeft();
        }

        current.leftChild = current.getLeft().getRight();
    }

    public void deleteMax() {
        ensureIsNonEmpty();

        if (this.root.getRight() == null) {
            this.root = this.root.getRight();
            return;
        }

        Node<E> current = this.root;
        while (current.getRight().getRight() != null) {
            current = current.getRight();
        }

        current.rightChild = current.getRight().getLeft();
    }

    public int count() {
        return getCount(this.root);
    }

    public int rank(E element) {
        return nodeRank(this.root, element);
    }

    public E floor(E element) {
        if (this.root == null) {
            return null;
        }

        Node<E> current = this.root;
        Node<E> nearestSmaller = null;

        while (current != null) {
            if (isGreater(element, current)) {
                nearestSmaller = current;
                current = current.getRight();
            } else if (isLess(element, current)) {
                current = current.getLeft();
            } else {
                Node<E> left = current.getLeft();
                if (left != null & nearestSmaller != null) {
                    nearestSmaller = isGreater(left.getValue(), nearestSmaller) ? left : nearestSmaller;
                } else if (nearestSmaller == null){
                    nearestSmaller = left;
                }

                break;
            }
        }

        return nearestSmaller == null ? null : nearestSmaller.getValue();
    }

    public E ceil(E element) {
        if (this.root == null) {
            return null;
        }

        Node<E> current = this.root;
        Node<E> nearestGreater = null;

        while (current != null) {
            if (isGreater(element, current)) {
                current = current.getRight();
            } else if (isLess(element, current)) {
                nearestGreater = current;
                current = current.getLeft();
            } else {
                Node<E> right = current.getRight();
                if (right != null & nearestGreater != null) {
                    nearestGreater = isLess(right.getValue(), nearestGreater) ? right : nearestGreater;
                } else if (nearestGreater == null){
                    nearestGreater = right;
                }

                break;
            }
        }

        return nearestGreater == null ? null : nearestGreater.getValue();
    }

    private int nodeRank(Node<E> node, E element) {
        if (node == null) {
            return 0;
        }

        if (isLess(element, node)) {
            return nodeRank(node.getLeft(), element);
        } else if (isEqual(element, node)) {
            return getCount(node.getLeft());
        }

        return getCount(node.getLeft()) + 1 + nodeRank(node.getRight(), element);
    }

    private int getCount(Node<E> node) {
        if (node == null) {
            return 0;
        }

        return 1 + getCount(node.getLeft()) + getCount(node.getRight());
    }

    private Node<E> searchNode(Node<E> node, E element) {
        if (node == null) {
            return null;
        }

        if (isEqual(element, node)) {
            return node;
        } else if (isGreater(element, node)) {
            return searchNode(node.getRight(), element);
        }

        return searchNode(node.getLeft(), element);
    }

    private boolean containsNode(Node<E> node, E element) {
        if (node == null) {
            return false;
        }

        if (isEqual(element, node)) {
            return true;
        } else if (isGreater(element, node)) {
            return containsNode(node.getRight(), element);
        }

        return containsNode(node.getLeft(), element);
    }

    private void insertInto(Node<E> node, E element) {
        if (isGreater(element, node)) {
            if (node.getRight() == null) {
                node.rightChild = new Node<>(element);
            } else {
                insertInto(node.getRight(), element);
            }
        } else if (isLess(element, node)) {
            if (node.getLeft() == null) {
                node.leftChild = new Node<>(element);
            } else {
                insertInto(node.getLeft(), element);
            }
        }
    }

    private void inOrder(Node<E> node, Consumer<E> consumer) {
        if (node == null) {
            return;
        }

        inOrder(node.getLeft(), consumer);
        consumer.accept(node.getValue());
        inOrder(node.getRight(), consumer);
    }

    private boolean isLess(E element, Node<E> node) {
        return element.compareTo(node.getValue()) < 0;
    }

    private boolean isGreater(E element, Node<E> node) {
        return element.compareTo(node.getValue()) > 0;
    }

    private boolean isEqual(E element, Node<E> node) {
        return element.compareTo(node.getValue()) == 0;
    }

    private void ensureIsNonEmpty() {
        if (this.root == null) {
            throw new IllegalArgumentException();
        }
    }
}
