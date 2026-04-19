package dataStructure.list.doublylinkedlist;

import java.util.StringJoiner;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class LinkedList<E> {
    Node head;
    Node tail;
    int size;

    public boolean addAtLastByIterate(E e) {
        Node newNode = new Node(e);
        if (isNull(head)) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (nonNull(currentNode.next)) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            newNode.prev = currentNode;
        }
        size++;
        tail = newNode;
        return true;
    }

    public boolean addAtFirst(E e) {
        Node newNode = new Node(e);
        if (isNull(head)) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        return true;
    }

    public boolean addAtLast(E e) {
        Node newNode = new Node(e);
        if (isNull(head)) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }


    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        Node currentNode = head;
        while (currentNode != null) {
            stringJoiner.add(String.valueOf(currentNode.data));
            currentNode = currentNode.next;
        }

        return stringJoiner.toString();
    }

    public String printReverseList() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        Node currentNode = tail;
        while (nonNull(currentNode)) {
            stringJoiner.add(String.valueOf(currentNode.data));
            currentNode = currentNode.prev;
        }
        return stringJoiner.toString();
    }

    public boolean removeAtFirst() {
        if (isNull(head)) {
            return false;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return true;
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
        return true;
    }

    public boolean removeAtLast() {
        if (isNull(head)) {
            return false;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return true;
        } else {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
        return true;
    }


    static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addAtLast(1);
        linkedList.addAtLast(2);
        linkedList.addAtLast(3);
        linkedList.addAtFirst(0);
        System.out.println(linkedList);
        linkedList.removeAtLast();
        System.out.println(linkedList);
        linkedList.removeAtFirst();
        System.out.println(linkedList);
        System.out.println(linkedList.size);

    }
}
