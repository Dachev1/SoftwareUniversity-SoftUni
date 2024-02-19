package Workshop1;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {
    private static final int INITIAL_CAPACITY = 4;
    private int capacity;
    private int size;
    private int[] items;

    public CustomStack() {
        this.capacity = INITIAL_CAPACITY;
        this.items = new int[INITIAL_CAPACITY];
    }

    public int getSize() {
        return this.size;
    }

    public void push(int element) {
        if (this.size == this.capacity) {
            this.resize();
        }

        this.items[this.size++] = element;
    }

    private void resize() {
        this.capacity *= 2;
        int[] temp = new int[this.capacity];

        System.arraycopy(this.items, 0, temp, 0, this.items.length);
        this.items = temp;
    }

    public int pop() {
        checkEmpty();

        int element = this.items[this.size - 1];
        this.size--;
        return element;
    }

    public int peek() {
        checkEmpty();
        return this.items[this.size - 1];
    }
    private void checkEmpty() {
        if (this.size == 0) {
            throw new NoSuchElementException("Is empty");
        }
    }

    public void forEach (Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.items[i]);
        }
    }
}
