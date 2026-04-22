package dataStructure.tree;

import static java.util.Objects.isNull;

import java.util.Stack;
import java.util.StringJoiner;

public class Traversal {
  public void inOrderByRecursive(Node node) {
    if (isNull(node)) {
      return;
    }
    inOrderByRecursive(node.left);
    System.out.print(node.data + "-->");
    inOrderByRecursive(node.right);
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

  public void preOrderByRecursive(Node node) {
    if (isNull(node)) {
      return;
    }
    System.out.print(node.data + "--->");
    preOrderByRecursive(node.left);
    preOrderByRecursive(node.right);
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

  public void postOrderByRecursive(Node node) {
    if (isNull(node)) {
      return;
    }
    postOrderByRecursive(node.left);
    postOrderByRecursive(node.right);
    System.out.println(node.data + "--->");
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
    /* traversal.inOrderByRecursive(tree.root);
    System.out.println();
    System.out.println(traversal.inOrderByIterative(tree.root));*/
    traversal.preOrderByRecursive(tree.root);
    System.out.println();
    System.out.println(traversal.preOrderByIterative(tree.root));
    /*    StringJoiner joinerPost = new StringJoiner(",", "[", "]");
    traversal.postOrderByRecursive(tree.root, item -> joinerPost.add(item.toString()));
    System.out.println("Post-order traversal: " + joinerPost);*/
    // System.out.println(traversal.postOrderByIterative(tree.root));
  }
}
