package core;

import model.Message;
import shared.DataTransferSystem;

import java.util.ArrayList;
import java.util.List;

public class MessagingSystem implements DataTransferSystem {
    private Node root;
    private int size;

    private static class Node {
        Message message;
        Node left;
        Node right;

        public Node(Message message) {
            this.message = message;
        }
    }

    @Override
    public void add(Message message) {
        if (this.root == null) {
            this.root = new Node(message);
        } else {
            this.add(this.root, message);
        }

        this.size++;
    }

    @Override
    public Message getByWeight(int weight) {
        Message messageToReturn = getMessageByWeight(this.root, weight);

        if (messageToReturn == null) {
            throw new IllegalArgumentException();
        }

        return messageToReturn;
    }

    @Override
    public Message getLightest() {
        isEmpty();

        return getLightest(this.root);
    }

    @Override
    public Message getHeaviest() {
        isEmpty();

        return getHeaviest(this.root);
    }

    @Override
    public Message deleteLightest() {
        isEmpty();

        Message lightestToDelete = getLightest();

        this.deleteLightest(this.root);

        this.size--;
        return lightestToDelete;
    }

    @Override
    public Message deleteHeaviest() {
        isEmpty();

        Message heaviestToDelete = getHeaviest();

        this.deleteHeaviest(this.root);

        this.size--;
        return heaviestToDelete;
    }

    @Override
    public Boolean contains(Message message) {
        return this.getMessageByWeight(this.root, message.getWeight()) != null;
    }

    @Override
    public List<Message> getOrderedByWeight() {
        return this.getInOrder();
    }

    @Override
    public List<Message> getPostOrder() {
        List<Message> messages = new ArrayList<>();

        this.getPostOrder(this.root, messages);

        return messages;
    }

    @Override
    public List<Message> getPreOrder() {
        List<Message> messages = new ArrayList<>();

        this.getPreOrder(this.root, messages);

        return messages;
    }

    @Override
    public List<Message> getInOrder() {
        List<Message> messages = new ArrayList<>();

        this.getInOrder(this.root, messages);

        return messages;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void add(Node node, Message message) {
        if (node.message.equals(message)) {
            throw new IllegalArgumentException();
        }

        if (node.message.getWeight() > message.getWeight()) {
            if (node.left == null) {
                node.left = new Node(message);
            } else {
                this.add(node.left, message);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(message);
            } else {
                this.add(node.right, message);
            }
        }
    }

    private Message getMessageByWeight(Node node, int weight) {
        if (node == null) {
            return null;
        }

        if (node.message.getWeight() == weight) {
            return node.message;
        }

        if (node.message.getWeight() > weight) {
            return this.getMessageByWeight(node.left, weight);
        } else {
            return this.getMessageByWeight(node.right, weight);
        }
    }

    private void isEmpty() {
        if (this.size() == 0) {
            throw new IllegalStateException();
        }
    }

    private Message getLightest(Node node) {
        while (node.left != null) {
            node = node.left;
        }

        return node.message;
    }

    private Message getHeaviest(Node node) {
        while (node.right != null) {
            node = node.right;
        }

        return node.message;
    }

    private void deleteLightest(Node node) {
        if (node.left == null) {
            this.root = node.right;
        } else {
            while (node.left.left != null) {
                node = node.left;
            }

            node.left = node.left.right;
        }
    }

    private void deleteHeaviest(Node node) {
        if (node.right == null) {
            this.root = node.left;
        } else {
            while (node.right.right != null) {
                node = node.right;
            }

            node.right = node.right.left;
        }
    }

    private void getPostOrder(Node node, List<Message> messages) {
        if (node == null) {
            return;
        }

        getPostOrder(node.left, messages);
        getPostOrder(node.right, messages);

        messages.add(node.message);
    }

    private void getPreOrder(Node node, List<Message> messages) {
        if (node == null) {
            return;
        }

        messages.add(node.message);

        getPreOrder(node.left, messages);
        getPreOrder(node.right, messages);
    }


    private void getInOrder(Node node, List<Message> messages) {
        if (node == null) {
            return;
        }

        getInOrder(node.left, messages);

        messages.add(node.message);

        getInOrder(node.right, messages);
    }
}
