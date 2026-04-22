package dataStructure.tree;

import java.util.Stack;

public class HighLevelProblem {
  public Node mergeTwoTree(Node n1, Node n2) {
    if (n1 == null && n2 == null) {
      return null;
    }
    if (n1 != null && n2 == null) {
      return n1;
    }
    if (n2 != null && n1 == null) {
      return n2;
    }
    Stack<NodePair> stack = new Stack<>();
    stack.push(new NodePair(n1, n2));
    while (!stack.isEmpty()) {
      NodePair nodePair = stack.pop();
      Node tree1 = nodePair.tree1;
      Node tree2 = nodePair.tree2;
      if (tree1 == null || tree2 == null) {
        continue;
      }
      tree1.data = (int) tree1.data + (int) tree2.data;
      if (tree1.left == null) {
        tree1.left = tree2.left;
      } else {
        stack.push(new NodePair(tree1.left, tree2.left));
      }
      if (tree1.right == null) {
        tree1.right = tree2.right;
      } else {
        stack.push(new NodePair(tree1.right, tree2.right));
      }
    }
    return n1;
  }

  public Node mergeTwoTreeByRecursion(Node n1, Node n2) {
    if (n1 == null) {
      return n2;
    }
    if (n2 == null) {
      return n1;
    }
    n1.data = (int) n1.data + (int) n1.data;
    n1.left = mergeTwoTree(n1.left, n2.left);
    n1.right = mergeTwoTree(n1.right, n2.right);

    return n1;
  }

  public static void main(String[] args) {
    // Construct the first Binary Tree
    //        1
    //      /   \
    //     2     3
    //    / \     \
    //   4   5     6

    Node root1 = new Node(1);
    root1.left = new Node(2);
    root1.right = new Node(3);
    root1.left.left = new Node(4);
    root1.left.right = new Node(5);
    root1.right.right = new Node(6);
    System.out.println();
    Tree tree11 = new Tree();
    tree11.root = root1;
    System.out.println(tree11);

    // Construct the second Binary Tree
    //      4
    //    /   \
    //   1     7
    //  /     /  \
    // 3     2    6

    Node root2 = new Node(4);
    root2.left = new Node(1);
    root2.right = new Node(7);
    root2.left.left = new Node(3);
    root2.right.left = new Node(2);
    root2.right.right = new Node(6);
    System.out.println();
    Tree tree12 = new Tree();
    tree12.root = root2;
    System.out.println(tree12);
    HighLevelProblem highLevelProblem = new HighLevelProblem();
    Node merged = highLevelProblem.mergeTwoTree(root1, root2);
    Tree tree = new Tree();
    tree.root = merged;
    System.out.println(tree.toString());
  }
}
