package task3;

import java.util.HashSet;
import java.util.List;

public class TreeImpl<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;
    private int size;

    @Override
    public void addValue(T value) {
        root = insert(root, value);
        size++;
    }

    @Override
    public void addAll(List<T> values) {
        for (T value : values) {
            addValue(value);
        }
    }

    @Override
    public HashSet<T> getValues(T inf, T sup) {
        HashSet<T> result = new HashSet<>();
        traverse(root, inf, sup, result);
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }

        int compareResult = value.compareTo(node.getValue());
        if (compareResult < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (compareResult > 0) {
            node.setRight(insert(node.getRight(), value));
        }

        return node;
    }

    private void traverse(Node<T> node, T inf, T sup, HashSet<T> result) {
        if (node == null) {
            return;
        }

        int compareInf = inf.compareTo(node.getValue());
        int compareSup = sup.compareTo(node.getValue());

        if (compareInf < 0) {
            traverse(node.getLeft(), inf, sup, result);
        }
        if (compareInf <= 0 && compareSup >= 0) {
            result.add(node.getValue());
        }
        if (compareSup > 0) {
            traverse(node.getRight(), inf, sup, result);
        }
    }
}