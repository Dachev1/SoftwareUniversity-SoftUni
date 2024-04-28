package solutions;

import interfaces.Decrease;
import interfaces.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap<E extends Comparable<E> & Decrease<E>> implements Heap<E> {
    private List<E> data;

    public MinHeap() {
        this.data = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public void add(E element) {
        this.data.add(element);

        this.heapifyUp();
    }

    @Override
    public E peek() {
        ensureIsNonEmpty();
        return this.data.get(0);
    }

    @Override
    public E poll() {
        ensureIsNonEmpty();

        Collections.swap(this.data, 0, this.size() - 1);
        E toReturn = this.data.remove(this.size() - 1);

        this.heapifyDown();

        return toReturn;
    }


    @Override
    public void decrease(E element) {
//        int elementIndex = this.data.indexOf(element);
//        E heapElement = this.getAt(elementIndex);
//
//        heapElement.decrease();
//
//        this.heapifyUp();
        this.data.remove(element);
        element.decrease();
        this.add(element);
    }

    private void heapifyUp() {
        int index = this.size() - 1;
        while (index > 0 && this.isGreater(this.getParentIndex(index), index)) {
            Collections.swap(this.data, index, this.getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        int swapIndex = getLeftChildIndex(index);

        while (swapIndex < this.data.size()) {
            int rightChildIndex = this.getRightChildIndex(index);

            if (rightChildIndex < this.data.size()) {
                swapIndex = this.isGreater(rightChildIndex, swapIndex) ? swapIndex : rightChildIndex;
            }

            if (this.isGreater(swapIndex, index)) {
                break;
            }

            Collections.swap(this.data, index, swapIndex);
            index = swapIndex;
            swapIndex = getLeftChildIndex(index);
        }
    }


    private boolean isGreater(int firstIndex, int secondIndex) {
        return this.getAt(firstIndex).compareTo(this.getAt(secondIndex)) > 0;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return (2 * index) + 1;
    }

    private int getRightChildIndex(int index) {
        return this.getLeftChildIndex(index) + 1;
    }

    private E getAt(int index) {
        return this.data.get(index);
    }

    private void ensureIsNonEmpty() {
        if (this.size() == 0) {
            throw new IllegalStateException();
        }
    }
}
