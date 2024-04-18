package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {
    private Node<E> head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    private static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E element) {
            this.value = element;
            this.next = null;
        }
    }

    @Override
    public void addFirst(E element) {
        Node<E> nextElement = new Node<>(element);
        nextElement.next = this.head;
        this.head = nextElement;

        this.size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> elementToAdd = new Node<>(element);

        if (isEmpty()) {
            this.head = elementToAdd;
        } else {
            Node<E> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = elementToAdd;
        }

        size++;
    }


    @Override
    public E removeFirst() {
        ensureNonEmpty();

        Node<E> toRemove = this.head;

        this.head = toRemove.next;
        size--;
        return toRemove.value;
    }

    @Override
    public E removeLast() {
        ensureNonEmpty();

        E value = null;
        if (this.size == 1) {
            value = this.head.value;
            this.head = null;
        } else {
            Node<E> preLast = this.head;
            Node<E> toRemove = this.head.next;
            while (toRemove.next != null) {
                preLast = toRemove;
                toRemove = toRemove.next;
            }
            value = toRemove.value;
            preLast.next = null;
        }
        size--;
        return value;
    }

    @Override
    public E getFirst() {
        ensureNonEmpty();
        return this.head.value;
    }

    @Override
    public E getLast() {
        ensureNonEmpty();
        Node<E> current = this.head.next;
        if (this.size == 1) {
            return this.head.value;
        }
        while (current.next != null) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private void ensureNonEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
    }
}
