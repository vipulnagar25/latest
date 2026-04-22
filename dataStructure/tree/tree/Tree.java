package dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class Tree<E> {
    Node root;
    int size;

    public boolean add(E e) {
        Node newNode = new Node(e);
        if (root == null) {
            root = newNode;
        } else {
            addElement(newNode);
        }
        size++;
        return true;
    }

    private void addElement(Node newNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.left == null) {
                currentNode.left = newNode;
                break;
            } else {
                queue.add(currentNode.left);
            }
            if (currentNode.right == null) {
                currentNode.right = newNode;
                break;
            } else {
                queue.add(currentNode.right);
            }
        }
    }

    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            stringJoiner.add(String.valueOf(currentNode.data));
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return stringJoiner.toString();

    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);

        System.out.println("Hello World!");
        System.out.println(tree);
    }
}
