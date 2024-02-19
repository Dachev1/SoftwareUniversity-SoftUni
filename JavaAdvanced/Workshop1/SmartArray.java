package Workshop1;

import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    private void resize() {
       this.capacity *= 2;
       int[] temp = new int[this.capacity];

        System.arraycopy(this.data, 0, temp, 0, this.data.length);
       this.data = temp;
    }

    public void add(int element) {
            if (this.size == capacity) {
                resize();
            }

            this.data[this.size++] = element;
    }

    public void add(int index, int element) {
       checkIndex(index);

       if (index == this.size - 1) {
           add(this.data[this.size - 1]);
           this.data[this.size - 2] = element;
       } else {
           this.size++;
           shiftRight(index);
           this.data[index] = element;
       }
    }



    public int get(int index) throws Exception{
        checkIndex(index);

        return this.data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Index %d is out of bounds", index));
        }
    }

    public int remove(int index) {
        checkIndex(index);

        int element = this.data[index];
        shift(index);
        this.size--;

        if (this.size <= this.capacity / 4) {
            shrink();
        }

        return element;
    }

    private void shift(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }

        this.data[size - 1] = 0;
    }

    private void shrink() {
        this.capacity /= 2;
        int[] temp = new int[this.capacity];

        System.arraycopy(this.data, 0, temp, 0, this.size);
        this.data = temp;
    }

    private void shiftRight(int index) {
        for (int i = this.size - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
    }

    public void forEach (Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }
}
