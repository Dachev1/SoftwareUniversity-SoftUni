package implementations;

import interfaces.AbstractBinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {
    private E key;
    private AbstractBinaryTree<E> leftChild;
    private AbstractBinaryTree<E> rightChild;

    public BinaryTree(E key, AbstractBinaryTree<E> leftChild, AbstractBinaryTree<E> rightChild) {
        this.setKey(key);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return this.leftChild;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return this.rightChild;
    }

    @Override
    public void setKey(E key) {
        this.key = key;
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder output = new StringBuilder();

        output.append(getPadding(indent))
                .append(this.key);

        if (this.getLeft() != null) {
            output.append(System.lineSeparator()).append(this.getLeft().asIndentedPreOrder(indent + 2));
        }

        if (this.getRight() != null) {
            output.append(System.lineSeparator()).append(this.getRight().asIndentedPreOrder(indent + 2));
        }

        // without trim, because remove spaces
        return output.toString();
    }

    private String getPadding(int indent) {
        StringBuilder padding = new StringBuilder();

        for (int i = 0; i < indent; i++) {
            padding.append(" ");
        }

        // without trim, because remove spaces
        return padding.toString();
    }


    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();

        result.add(this);

        if (this.getLeft() != null) {
            result.addAll(this.getLeft().preOrder());
        }

        if (this.getRight() != null) {
            result.addAll(this.getRight().preOrder());
        }

        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();

        if (this.getLeft() != null) {
            result.addAll(this.getLeft().inOrder());
        }

        result.add(this);

        if (this.getRight() != null) {
            result.addAll(this.getRight().inOrder());
        }

        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();

        if (this.getLeft() != null) {
            result.addAll(this.getLeft().postOrder());
        }

        if (this.getRight() != null) {
            result.addAll(this.getRight().postOrder());
        }

        result.add(this);

        return result;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if (this.getLeft() != null) {
                this.getLeft().forEachInOrder(consumer);
        }

        consumer.accept(this.getKey());

        if (this.getRight() != null) {
            this.getRight().forEachInOrder(consumer);
        }
    }
}
