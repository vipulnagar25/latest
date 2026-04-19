package dataStructure.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.TreeMap;

public class Problem {

    public int findHeightOfTreeByIterative(Tree<Integer> tree) {
        int max_height = -1;
        if (tree.root == null) {
            return max_height;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree.root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node currentNode = queue.poll();
                assert currentNode != null;
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.left);
                }
            }
            max_height++;
        }
        return max_height;
    }

    public int findHeightOfTreeByRecursive(Tree<Integer> tree) {
        int max_height = -1;
        if (tree.root == null) {
            return max_height;
        }
        return findHeightOfTreeByRecursive(tree.root);
    }

    public int findHeightOfTreeByRecursive(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(findHeightOfTreeByRecursive(node.left), findHeightOfTreeByRecursive(node.right));
    }

    public void treeTopView(Tree<Integer> tree) {
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Node> nodeMap = new TreeMap<>();
        queue.add(tree.root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int hd = currentNode.hd;
            if (!nodeMap.containsKey(hd)) {
                nodeMap.put(hd, currentNode);
            }
            if (currentNode.left != null) {
                currentNode.left.hd = currentNode.hd - 1;
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                currentNode.right.hd = currentNode.hd + 1;
                queue.add(currentNode.right);
            }

        }
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        nodeMap.values().forEach(e -> stringJoiner.add(String.valueOf(e.data)));
        System.out.println(stringJoiner);
    }

    public void treeLeftView(Tree<Integer> tree) {
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Node> nodeMap = new TreeMap<>();
        queue.add(tree.root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int level = currentNode.level;
            if (!nodeMap.containsKey(level)) {
                nodeMap.put(level, currentNode);
            }
            if (currentNode.left != null) {
                currentNode.left.level = level + 1;
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                currentNode.right.level = level + 1;
                queue.add(currentNode.right);
            }
        }
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        nodeMap.values().forEach(e -> stringJoiner.add(String.valueOf(e.data)));
        System.out.println(stringJoiner);
    }

    public void treeRightView(Tree<Integer> tree) {
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Node> nodeMap = new TreeMap<>();
        queue.add(tree.root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int level = currentNode.level;
            nodeMap.put(level, currentNode);
            if (currentNode.left != null) {
                currentNode.left.level = level + 1;
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                currentNode.right.level = level + 1;
                queue.add(currentNode.right);
            }
        }
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        nodeMap.values().forEach(e -> stringJoiner.add(String.valueOf(e.data)));
        System.out.println(stringJoiner);
    }

    public void treeBottomView(Tree<Integer> tree) {
        if (tree == null || tree.root == null) {
            System.out.println("[]");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        // Use a TreeMap to keep nodes sorted by horizontal distance
        Map<Integer, Node> nodeMap = new TreeMap<>();

        tree.root.hd = 0;
        queue.add(tree.root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int hd = currentNode.hd;
            nodeMap.put(hd, currentNode);
            if (currentNode.left != null) {
                currentNode.left.hd = hd - 1;
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                currentNode.right.hd = hd + 1;
                queue.add(currentNode.right);
            }
        }
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        nodeMap.values().forEach(e -> stringJoiner.add(String.valueOf(e.data)));
        System.out.println(stringJoiner);
    }


    public void treeLeafNodePrint(Tree<Integer> tree) {
        if (tree == null || tree.root == null) {
            System.out.println("[]");
            return;
        }
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree.root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (Objects.isNull(currentNode.left) && Objects.isNull(currentNode.right)) {
                stringJoiner.add(String.valueOf(currentNode.data));
            }
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        System.out.println(stringJoiner);
    }

    public void printZigZagTree(Tree<Integer> tree) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> lists = new LinkedList<>();
        boolean isLeftStart = true;
        queue.add(tree.root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            while (size-- > 0) {
                Node currentNode = queue.poll();
                assert currentNode != null;
                list.add((Integer) currentNode.data);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            if (isLeftStart) {
                lists.add(list);
                isLeftStart = false;
            } else {
                lists.add(list.reversed());
                isLeftStart = true;
            }

        }
        System.out.println(lists);
    }

    public static void main(String[] args) {
        Problem problem = new Problem();
        Tree<Integer> tree = new Tree<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        tree.add(11);
        System.out.println(tree);
        int heighByIterative = problem.findHeightOfTreeByIterative(tree);
        int heighByRecursive = problem.findHeightOfTreeByRecursive(tree);
        System.out.println("heighByIterative" + "::::" + heighByIterative + "," + "heighByRecursive" + "::::" + heighByRecursive);
        problem.treeTopView(tree);
        problem.treeLeftView(tree);
        problem.treeRightView(tree);
        problem.treeBottomView(tree);
        problem.treeLeafNodePrint(tree);
        problem.printZigZagTree(tree);
    }
}
