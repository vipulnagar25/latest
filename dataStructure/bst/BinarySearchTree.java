package dataStructure.bst;


import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


public class BinarySearchTree<E> {
    Node root;

    public boolean add(E e) {
        Node newNode = new Node(e);
        if (root == null) {
            root = newNode;
            return true;
        }
        Queue queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = (Node) queue.poll();
            int oldData = (int) currentNode.data;
            int newData = (int) newNode.data;
            if (newData < oldData) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                } else {
                    queue.add(currentNode.left);
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    break;
                } else {
                    queue.add(currentNode.right);
                }

            }
        }
        return true;
    }

    public boolean delete(int key) {
        if (root == null) {
            System.out.println("Nothing to delete form here !");
            return false;
        }
        Node currentNode = root;
        Node previousNode = null;
        boolean isLeftChild = false;
        while (currentNode != null && (int) currentNode.data != key) {
            if (key < (int) currentNode.data) {
                previousNode = currentNode;
                currentNode = currentNode.left;
                isLeftChild = true;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.right;
                isLeftChild = false;
            }

        }
        if (currentNode == null) {
            System.out.println("Data is not present in the tree");
            return false;
        }
        // case if  current node  is leaf node
        if (isNull(currentNode.left) && isNull(currentNode.right)) {
            if (isLeftChild) {
                previousNode.left = null;
            } else {
                previousNode.right = null;
            }
        }
        // case if current nod has only one child node
        // case if  current node  is leaf node
        else if (nonNull(currentNode.left) && isNull(currentNode.right)) {
            if (isLeftChild) {
                previousNode.left = currentNode.left;
            } else {
                previousNode.right = currentNode.left;

            }
        } else if (nonNull(currentNode.right) && isNull(currentNode.left)) {
            if (isLeftChild) {
                previousNode.left = currentNode.right;
            } else {
                previousNode.right = currentNode.right;

            }

        } else if (nonNull(currentNode.left) && nonNull(currentNode.right)) {
            Node successor = getSuccessor(currentNode);

            // Replace the node to be deleted with the successor
            if (currentNode == root) {
                root = successor;
            } else if (isLeftChild) {
                previousNode.left = successor;
            } else {
                previousNode.right = successor;
            }
            // Attach the original left subtree to the successor
            successor.left = currentNode.left;
        }

        return true;
    }


    private Node getSuccessor(Node nodeToDelete) {
        Node parentOfSuccessor = nodeToDelete;
        Node successor = nodeToDelete.right;


        // Find the leftmost node in the right subtree
        while (nonNull(successor.left)) {
            parentOfSuccessor = successor;
            successor = successor.left;
        }

        // If the successor is not the immediate right child of the node to be deleted,
        // we need to move the successor's right child up to take its place
        // and attach the original right subtree to the successor.
        if (successor != nodeToDelete.right) {
            parentOfSuccessor.left = successor.right;
            successor.right = nodeToDelete.right;
        }
        return successor;
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
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(13);
        bst.add(7);
        bst.add(15);
        bst.add(3);
        bst.add(8);
        bst.add(14);
        bst.add(19);
        bst.add(18);
        System.out.println(bst);
        bst.delete(15);
        System.out.println(bst);
    }
}
