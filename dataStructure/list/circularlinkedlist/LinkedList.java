package dataStructure.list.circularlinkedlist;

import java.util.StringJoiner;

public class LinkedList<E> {
    Node last;
    int size;

    public boolean addLast(E e) {
        Node newNode = new Node(e);
        if (last == null) {
            last = newNode;
            last.next = newNode;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        size++;
        return true;
    }

    public boolean addFirst(E e) {
        Node newNode = new Node(e);
        if (last == null) {
            last = newNode;
        } else {
            newNode.next = last.next;
        }
        last.next = newNode;
        size++;
        return true;
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        Node currentNode = last.next; // Start at the head
        do {
            joiner.add(String.valueOf(currentNode.data));
            currentNode = currentNode.next;
        } while (currentNode != last.next);

        return joiner.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        System.out.println(linkedList);
    }
}
