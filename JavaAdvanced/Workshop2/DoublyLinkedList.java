package Workshop2;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList {

    private class ListNode {
        private int item;
        private ListNode next;
        private ListNode prev;

        private ListNode(int item) {
            this.item = item;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public void addFirst(int element) {
        ListNode newHead = new ListNode(element);

        if (this.size == 0) {
            this.head = this.tail = newHead;
        } else {
            newHead.next = this.head;
            this.head.prev = newHead;
            this.head = newHead;
        }


        this.size++;
    }

    public void addLast(int element) {
        ListNode newTail = new ListNode(element);

        if (this.size == 0) {
            this.head = this.tail = newTail;
        } else {
            newTail.prev = this.tail;
            this.tail.prev = newTail;
            this.tail = newTail;
        }


        this.size++;
    }

    public int get(int index) {
        checkIndex(index);

        if (index <= this.size / 2) {
            ListNode firstNode = this.head;

            for (int i = 0; i < index; i++) {
                firstNode = firstNode.next;
            }

            return firstNode.item;
        } else {
            ListNode lastNode = this.tail;

            for (int i = this.size - 1; i > index; i--) {
                lastNode = lastNode.prev;
            }

            return lastNode.item;
        }
    }

    public int removeFirst() {
        checkSize();

        int firstItem = this.head.item;
        this.head = this.head.next;

        if (this.head == null) {
            this.tail = null;
        } else {
            this.head.prev = null;
        }

        this.size--;
        return firstItem;
    }

    public int removeLast() {
        checkSize();

        int lastElement = this.tail.item;
        this.tail = this.tail.prev;

        if (this.tail == null) {
            this.head = null;
        } else {
            this.tail.next = null;
        }

        this.size--;
        return lastElement;
    }

    public void forEach(Consumer<Integer> consumer) {
        ListNode currentNode = this.head;

        while (currentNode != null) {
            consumer.accept(currentNode.item);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        int[] arr = new int[this.size];
        int counter = 0;
        ListNode currentNode = this.head;

        while (currentNode != null) {
            arr[counter++] = currentNode.item;
            currentNode = currentNode.next;
        }

        return arr;
    }

    private void checkSize() {
        if (this.size == 0) {
            throw new NoSuchElementException("Is empty");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
