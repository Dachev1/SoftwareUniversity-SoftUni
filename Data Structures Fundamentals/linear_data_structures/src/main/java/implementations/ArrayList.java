package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class ArrayList<E> implements List<E> {
    private static final int INITIAL_LENGTH = 4;
    private Object[] elements;
    int size;

    public ArrayList() {
        this.elements = new Object[INITIAL_LENGTH];
        this.size = 0;
    }

    @Override
    public boolean add(E element) {
        ifNeedToGrow();
        this.elements[size++] = element;

        return true;
    }

    @Override
    public boolean add(int index, E element) {
        checkIndex(index);
        insert(index, element);

        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index);

        return (E) this.elements[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        Object changedElement = this.elements[index];
        this.elements[index] = element;

        return (E) changedElement;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        checkDoesHaveAnyElements();
        Object removedElement = this.elements[index];
        shiftTheArray(index);
        shrinkIfNeeded();
        this.size--;

        return (E) removedElement;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean contains(E element) {
        return this.indexOf(element) != -1;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < size;
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    private void ifNeedToGrow() {
        if (this.size == this.elements.length) {
            this.elements =  grow();
        }
    }

    private Object[] grow() {
      return Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    private void checkIndex(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void insert(int index, E element) {
        ifNeedToGrow();
        for (int i = this.size; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[index] = element;
        size++;
    }

    private void shiftTheArray(int index) {
        for (int i = index; i < this.size; i++) {
            this.elements[i] = this.elements[i + 1];
        }
    }

    private void shrinkIfNeeded() {
        if (this.size < this.elements.length / 3) {
            this.elements = Arrays.copyOf(this.elements, this.elements.length / 2);
        }
    }

    private void checkDoesHaveAnyElements() {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException();
        }
    }
}
