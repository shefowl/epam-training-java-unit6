package by.epam.money.structures;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E extends Comparable<E>> {
    Node root;

    public void add(E value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, E value) {
        if (current == null) {
            return new Node(value);
        }

        if (value.compareTo((E) current.value) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo((E) current.value) > 0) {
            current.right = addRecursive(current.right, value);
        } else {
            //value already exists
            return current;
        }

        return current;
    }

    public boolean containsNode(E value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, E value) {
        if (current == null) {
            return false;
        }
        if (value.compareTo((E)current.value) == 0) {
            return true;
        }
        return value.compareTo((E) current.value) < 0
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public void delete(E value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, E value) {
        if (current == null) {
            return null;
        }

        if (value.compareTo((E)current.value) == 0) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            E smallestValue = (E)findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;

        }
        if (value.compareTo((E)current.value) < 0) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private E findSmallestValue(Node root) {
        if(root.left == null){
            return (E)root.value;
        }
        else{
            return (E)findSmallestValue(root.left);
        }
    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right!= null) {
                nodes.add(node.right);
            }
        }
    }

    class Node<V extends Comparable<V>> {
        V value;
        Node left;
        Node right;

        Node(V value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
}
