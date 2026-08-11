package dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ProblemSet2 {
  public static boolean isIdenticalByRecursion(Node root1, Node root2) {
    if (root1 == null && root2 == null) {
      return true;
    }
    if (root1 == null || root2 == null) {
      return false;
    }
    return root1.data == root2.data
        && isIdenticalByRecursion(root1.left, root2.left)
        && isIdenticalByRecursion(root1.right, root2.right);
  }

  public static boolean isIdenticalByIterative(Node root1, Node root2) {
    Queue<Node> queue1 = new LinkedList<>();
    Queue<Node> queue2 = new LinkedList<>();
    queue1.add(root1);
    queue2.add(root2);
    while (!queue1.isEmpty() && !queue2.isEmpty()) {
      Node cur1 = queue1.poll();
      Node cur2 = queue2.poll();
      if (cur1 == null && cur2 == null) {
        continue;
      }
      if (cur1 == null || cur2 == null || cur1.data != cur2.data) {
        return false;
      }
      queue1.add(cur1.left);
      queue2.add(cur2.left);

      queue1.add(cur1.right);
      queue2.add(cur2.right);
    }
    return queue1.isEmpty() && queue2.isEmpty();
  }

  static void main() {
    // Representation of input binary tree 1
    //        1
    //       / \
    //      2   3
    //     /
    //    4
    Node r1 = new Node(1);
    r1.left = new Node(2);
    r1.right = new Node(3);
    r1.left.left = new Node(4);

    // Representation of input binary tree 2
    //        1
    //       / \
    //      2   3
    //     /
    //    4
    Node r2 = new Node(1);
    r2.left = new Node(2);
    r2.right = new Node(3);
    r2.left.left = new Node(4);

    if (isIdenticalByRecursion(r1, r2)) System.out.println("true");
    else System.out.println("false");
    if (isIdenticalByIterative(r1, r2)) System.out.println("true");
    else System.out.println("false");
  }
}
