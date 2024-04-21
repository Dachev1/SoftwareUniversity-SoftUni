package implementations;

import interfaces.AbstractQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {
    private List<E> elements;

    public PriorityQueue() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public void add(E element) {
        this.elements.add(element);
        this.heapifyUp(this.size() - 1);
    }

    @Override
    public E peek() {
        ensureIsNonEmpty();
        return this.getAt(0);
    }

    @Override
    public E poll() {
        ensureIsNonEmpty();
        E element = this.elements.get(0);

        Collections.swap(this.elements, 0, this.size() - 1);
        this.elements.remove(this.size() - 1);
        this.heapifyDown(0);
        return element;
    }

    private void ensureIsNonEmpty() {
        if (this.size() == 0) {
            throw new IllegalStateException();
        }
    }


    private void heapifyUp(int index) {
        while (index > 0 && isLess(getParentIndex(index), index)) {
            Collections.swap(this.elements, this.getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown(int index) {
        int child;
        while (getLeftChildIndex(index) < this.size() && isLess(index, getLeftChildIndex(index))) {
            child = getLeftChildIndex(index);
            if (getRightChildIndex(index) < this.size() && isLess(child, getRightChildIndex(index))) {
                child = getRightChildIndex(index);
            }

            Collections.swap(this.elements, child, index);
            index = child;
        }
    }

    private int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int getRightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private boolean isLess(int first, int second) {
        return this.getAt(first).compareTo(this.getAt(second)) < 0;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private E getAt(int index) {
        return this.elements.get(index);
    }
}
