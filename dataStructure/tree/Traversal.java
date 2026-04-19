package dataStructure.tree;

import java.util.Stack;
import java.util.StringJoiner;
import java.util.function.Consumer;

import static java.util.Objects.isNull;

public class Traversal {
    public void inOrderByRecursive(Node node, Consumer<Object> action) {
        if (isNull(node)) {
            return;
        }
        inOrderByRecursive(node.left, action);
        action.accept(node.data);
        inOrderByRecursive(node.right, action);
    }

    public String inOrderByIterative(Node node) {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        Stack<Node> stack = new Stack<>();
        Node current = node;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            stringJoiner.add(current.data.toString());
            current = current.right;
        }

        return stringJoiner.toString();
    }

    public void preOrderByRecursive(Node node, Consumer<Object> action) {
        if (isNull(node)) {
            return;
        }
        action.accept(node.data);
        preOrderByRecursive(node.left, action);
        preOrderByRecursive(node.right, action);
    }

    public void postOrderByRecursive(Node node, Consumer<Object> action) {
        if (isNull(node)) {
            return;
        }
        postOrderByRecursive(node.left, action);
        postOrderByRecursive(node.right, action);
        action.accept(node.data);

    }

    public String preOrderByIterative(Node node) {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            stringJoiner.add(currentNode.data.toString());
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
        return stringJoiner.toString();
    }

    public String postOrderByIterative(Node node) {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        Stack<Node> stack = new Stack<>();
        Stack<Node> result = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            result.push(currentNode);
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
        }
        while (!result.isEmpty()) {
            Node currentNode = result.pop();
            stringJoiner.add(currentNode.data.toString());
        }
        return stringJoiner.toString();
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        for (int i = 1; i < 8; i++) {
            tree.add(i);
        }
        System.out.println(tree);
        Traversal traversal = new Traversal();
        StringJoiner joinerIn = new StringJoiner(",", "[", "]");
        traversal.inOrderByRecursive(tree.root, item -> joinerIn.add(item.toString()));
        System.out.println("In-order traversal: " + joinerIn);
        StringJoiner joinerPre = new StringJoiner(",", "[", "]");
        traversal.preOrderByRecursive(tree.root, item -> joinerPre.add(item.toString()));
        System.out.println("Pre-order traversal: " + joinerPre);
        StringJoiner joinerPost = new StringJoiner(",", "[", "]");
        traversal.postOrderByRecursive(tree.root, item -> joinerPost.add(item.toString()));
        System.out.println("Post-order traversal: " + joinerPost);
       // System.out.println(traversal.postOrderByIterative(tree.root));
    }
}
