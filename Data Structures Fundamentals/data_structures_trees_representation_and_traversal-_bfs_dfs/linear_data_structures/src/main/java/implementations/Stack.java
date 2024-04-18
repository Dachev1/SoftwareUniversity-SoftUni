package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {
    private Node<E> top;
    private int size;

    public Stack() {
        this.top = null;
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
    public void push(E element) {
        Node<E> elementToPush = new Node<>(element);
        elementToPush.next = this.top;
        this.top = elementToPush;
        this.size++;
    }

    @Override
    public E pop() {
        ensureIsNonEmpty();

        E topElement = this.top.value;
        Node<E> tmp = this.top.next;
        this.top.next = null;
        this.top = tmp;
        this.size--;
        return topElement;
    }

    @Override
    public E peek() {
        ensureIsNonEmpty();
        return this.top.value;
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
        return new Iterator<E>() {
            Node<E> current = top;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.value;
                current = current.next;

                return element;
            }
        };
    }

    private void ensureIsNonEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
    }
}
