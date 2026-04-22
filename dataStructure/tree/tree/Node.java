package dataStructure.tree;

public class Node {
    Node left;
    Node right;
    Object data;
    int hd;
    int level;

    public Node(Object data) {
        this.data = data;
        left = null;
        right = null;
    }
}
