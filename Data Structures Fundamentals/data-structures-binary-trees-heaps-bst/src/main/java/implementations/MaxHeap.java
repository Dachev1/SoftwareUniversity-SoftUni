package implementations;

import interfaces.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {
    private List<E> elements;

    public MaxHeap() {
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
        if (this.size() == 0) {
            throw new IllegalStateException("Heap is empty upon peek attempt");
        }

        return this.getAt(0);
    }

    private void heapifyUp(int index) {
        while (index > 0 && isLess(this.getParentIndex(index), index)) {
            Collections.swap(this.elements, this.getParentIndex(index), index);
            index = getParentIndex(index);;
        }
    }

    private boolean isLess(int parentIndex, int childIndex) {
        return this.getAt(parentIndex).compareTo(this.getAt(childIndex)) < 0;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }


    private E getAt(int index) {
        return this.elements.get(index);
    }
}
