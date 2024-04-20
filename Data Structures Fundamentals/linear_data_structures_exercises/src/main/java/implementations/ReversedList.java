package implementations;

import java.util.Arrays;
import java.util.Iterator;

public class ReversedList<E> implements Iterable<E> {
    private static final int INITIAL_SIZE = 2;
    private Object[] elements;
    private int size;

    public ReversedList() {
        this.elements = new Object[INITIAL_SIZE];
        this.size = 0;
    }

    public void add(E element) {
        if (this.size >= this.capacity()) {
            this.elements = grow();
        }
        this.elements[size++] = element;
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.elements.length;
    }

    public E get(int index) {
        checkIndex(index);
        return getAt(this.size - 1 - index);
    }

    public E removeAt(int index) {
        checkIndex(index);
        int indexToRemove = this.size - 1 - index;

        E element = getAt(indexToRemove);
        shift(indexToRemove);
        this.size--;

        shrinkIfNeeded();

        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private final class ListIterator implements Iterator<E> {
        private int index;

        public ListIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return size > this.index;
        }

        @Override
        public E next() {
            return get(this.index++);
        }
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private Object[] grow() {
        return Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    @SuppressWarnings("unchecked")
    private E getAt(int index) {
        return (E) this.elements[index];
    }


    private void shrinkIfNeeded() {
        if (this.size < this.elements.length / 4) {
            this.elements = Arrays.copyOf(this.elements, this.elements.length / 2);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException();
        }
    }

    private void shift(int index) {

        System.arraycopy(elements, index + 1,
                elements, index, this.size - 1 - index);

        elements[this.size - 1] = null;
    }

}
