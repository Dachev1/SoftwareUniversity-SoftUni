package Generics.Exercise.CustomListIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T remove(int index) {
        checkIndex(index);
        return this.data.remove(index);
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        checkIndex(firstIndex);
        checkIndex(secondIndex);
        T firstElement = data.get(firstIndex);
        T secondElement = data.get(secondIndex);
        this.data.set(firstIndex, secondElement);
        this.data.set(secondIndex, firstElement);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T t : this.data) {
            int result = t.compareTo(element);
            if (result > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        checkEmpty();
        return Collections.max(this.data);
    }

    public T getMin() {
        checkEmpty();
        return Collections.min(this.data);
    }

    public int getSize() {
        return this.data.size();
    }

    public T get(int index) {
        checkIndex(index);
        return this.data.get(index);
    }

    public void print() {
        for (int i = 0; i < this.data.size(); i++) {
            System.out.printf("%s%n", this.data.get(i));
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.data.size()) {
            throw new IndexOutOfBoundsException(String.format("Index %d is out of bounds for size %d.", index, this.data.size()));
        }
    }

    private void checkEmpty() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("List is Empty");
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < data.size();
            }

            @Override
            public T next() {
                return data.get(index++);
            }
        };
    }
}