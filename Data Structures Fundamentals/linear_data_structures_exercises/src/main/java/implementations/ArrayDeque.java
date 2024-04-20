package implementations;

import interfaces.Deque;

import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E> {
    private static final int INITIAL_SIZE = 7;
    private Object[] elements;
    private int size;
    private int head;
    private int tail;

    public ArrayDeque() {
        this.elements = new Object[INITIAL_SIZE];
        this.size = 0;
        this.head = this.tail = this.elements.length / 2;
    }

    @Override
    public void add(E element) {
        this.addLast(element);
    }

    @Override
    public void offer(E element) {
        addLast(element);
    }

    @Override
    public void addFirst(E element) {
        if (isEmpty()) {
            this.elements[this.head] = element;
        } else {
            if (this.head == 0) {
                this.elements = grow();
            }

            this.elements[--this.head] = element;
        }

        this.size++;
    }

    @Override
    public void addLast(E element) {
        if (isEmpty()) {
            this.elements[this.tail] = element;
        } else {
            if (this.tail == this.elements.length - 1) {
                this.elements = grow();
            }

            this.elements[++this.tail] = element;
        }
        this.size++;
    }

    @Override
    public void push(E element) {
        addFirst(element);
    }

    @Override
    public void insert(int index, E element) {
        int realIndex = this.head + index;
        this.ensureIndex(realIndex);

        if (realIndex - this.head < this.tail - realIndex) {
            if (realIndex == this.head) {
                this.addFirst(element);
            } else {
                shiftAndInsertLeftSide(realIndex - 1, element);
            }
        } else {
            if (realIndex == this.tail) {
                this.addLast(element);
            } else {
                shiftAndInsertRightSide(realIndex, element);
            }
        }
    }

    @Override
    public void set(int index, E element) {
        int realIndex = this.head + index;
        ensureIndex(realIndex);

        for (int i = this.head; i <= this.tail; i++) {
            if (i == realIndex) {
                this.elements[i] = element;
            }
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return this.getAt(this.head);
    }

    @Override
    public E poll() {
     return  this.removeFirst();
    }

    @Override
    public E pop() {
       return this.removeLast();
    }

    @Override
    public E get(int index) {
        int realIndex = this.head + index;
        ensureIndex(realIndex);
        return this.getAt(realIndex);
    }

    @Override
    public E get(Object object) {
        if (isEmpty()) {
            return null;
        }
        for (int i = this.head; i <= this.tail; i++) {
            if (this.elements[i].equals(object)) {
                return this.getAt(i);
            }
        }
        return null;
    }

    @Override
    public E remove(int index) {
        int realIndex = this.head + index;
        ensureIndex(index);
        return this.getAt(realIndex);
    }

    @Override
    public E remove(Object object) {
        if (isEmpty()) {
            return null;
        }
        for (int i = this.head; i <= this.tail; i++) {
            if (this.elements[i].equals(object)) {
                E element = this.getAt(i);
                this.elements[i] = null;
                for (int j = i; j < this.tail; j++) {
                    this.elements[j] = this.elements[j + 1];
                }
                this.removeLast();
                return element;
            }
        }
        return null;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E currentHeadElement = this.getAt(this.head);
        this.elements[this.head] = null;
        this.head++;
        this.size--;
        return currentHeadElement;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        E currentTailElement = this.getAt(this.tail);
        this.elements[this.tail] = null;
        this.tail--;
        this.size--;
        return currentTailElement;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.elements.length;
    }

    @Override
    public void trimToSize() {
        Object[] tmp = new Object[this.size];

        int index = 0;
        for (int i = this.head; i <= this.tail; i++) {
            tmp[index++] = this.elements[i];
        }

        this.elements = tmp;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = head;
            @Override
            public boolean hasNext() {
                return index <= tail;
            }

            @Override
            public E next() {
                return getAt(index++);
            }
        };
    }

    private Object[] grow() {
        Object[] tmp = new Object[this.elements.length * 2 + 1];

        int begin = (tmp.length / 2);
        int index = this.head;

        for (int i = begin; index <= this.tail; i++) {
            tmp[i] = this.elements[index++];
        }
        this.head = begin;
        this.tail = this.head + this.size - 1;

        return tmp;
    }

    @SuppressWarnings("unchecked")
    private E getAt(int index) {
        return (E) this.elements[index];
    }


    private void ensureIndex(int index) {
        if (index < this.head || index > this.tail) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void shiftAndInsertLeftSide(int index, E element) {
        E firstElement = this.getAt(this.head);
        for (int i = this.head; i < index; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[index] = element;
        this.addFirst(firstElement);
    }


    private void shiftAndInsertRightSide(int index, E element) {
        E lastElement = this.getAt(this.tail);
        for (int i = this.tail; i > index ; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[index] = element;
        this.addLast(lastElement);
    }
}
