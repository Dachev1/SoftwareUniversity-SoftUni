package core;

import model.Task;
import shared.Scheduler;

import java.util.ArrayList;
import java.util.List;

public class
ProcessScheduler implements Scheduler {
    private Node first;
    private Node last;
    private int size;

    private static class Node {
        private Task task;
        private Node next;

        public Node(Task task) {
            this.task = task;
        }
    }

    @Override
    public void add(Task task) {
        if (this.size() == 0) {
            this.first = this.last = new Node(task);
        } else {
            addTaskAfterLast(this.last, task);
        }

        this.size++;
    }

    @Override
    public Task process() {
        if (this.size() == 0) {
            return null;
        }

        Task taskToRemove = this.peek();

        this.remove(taskToRemove.getId());

        return taskToRemove;
    }

    @Override
    public Task peek() {
        if (this.size() == 0) {
            return null;
        }

        return this.first.task;
    }

    @Override
    public Boolean contains(Task task) {
        Node node = this.first;
        while (node != null) {
            if (node.task.getId() == task.getId()) {
                return true;
            }

            node = node.next;
        }

        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Boolean remove(Task task) {
        return this.remove(task.getId());
    }

    @Override
    public Boolean remove(int id) {
        NodeAndPrevious result = getNodeAndPreviousByTaskId(id);

        if (result.node == this.first) {
            this.first = result.node.next;
        } else {
            result.previous.next = result.node.next;
            if (this.last == result.node) {
                this.last = result.previous;
            }
        }

        this.size--;
        return true;
    }

    @Override
    public void insertBefore(int id, Task task) {
        NodeAndPrevious result = getNodeAndPreviousByTaskId(id);

        if (result.node == first) {
            Node node = new Node(task);
            node.next = first;
            first = node;
        } else {
            addTaskAfterLast(result.previous, task);
        }

        this.size++;
    }

    @Override
    public void insertAfter(int id, Task task) {
        Node node = getNodeByTaskId(id);

        this.addTaskAfterLast(node, task);
        this.size++;
    }

    @Override
    public void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public Task[] toArray() {
        Task[] result = new Task[this.size()];
        List<Task> list = this.toList();

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    @Override
    public void reschedule(Task first, Task second) {
        Node a = this.getNodeByTaskId(first.getId());
        Node b = this.getNodeByTaskId(second.getId());

        Task aTask = a.task;
        a.task = b.task;
        b.task = aTask;

    }

    @Override
    public List<Task> toList() {
        List<Task> result = new ArrayList<>();

        Node node = this.first;
        while (node.next != null) {
            result.add(node.task);
            node = node.next;
        }

        // because we stop and last and didn't added
        result.add(node.task);
        return result;
    }

    @Override
    public void reverse() {
        List<Task> list = this.toList();
        this.clear();

        for (int i = list.size() - 1; i >= 0; i--) {
            this.add(list.get(i));
        }
    }

    @Override
    public Task find(int id) {
        Node searchedTaskById = this.getNodeByTaskId(id);

        return searchedTaskById.task;
    }

    @Override
    public Task find(Task task) {
        Node searchedByTask = this.getNodeByTaskId(task.getId());

        return searchedByTask.task;
    }

    private void addTaskAfterLast(Node destination, Task task) {
        Node node = new Node(task);
        if (destination == last) {
            this.last = node;
        } else {
            node.next = destination.next;
        }

        destination.next = node;
    }

    private Node getNodeByTaskId(int id) {
        Node node = this.first;
        while (node != null) {
            if (node.task.getId() == id) {
                return node;
            }

            node = node.next;
        }

        throw new IllegalArgumentException();
    }

    private static class NodeAndPrevious {
        private final Node node;
        private final Node previous;

        public NodeAndPrevious(Node node, Node previous) {
            this.node = node;
            this.previous = previous;
        }
    }

    private NodeAndPrevious getNodeAndPreviousByTaskId(int id) {
        Node previous = null;
        Node node = this.first;
        while (node != null) {
            if (node.task.getId() == id) {
                return new NodeAndPrevious(node, previous);
            }

            previous = node;
            node = node.next;
        }

        throw new IllegalArgumentException();
    }
}
