package dataStructure.list.singlelinkedlist;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.StringJoiner;

public class LinkedList<E> {
  Node head;
  int size;

  public boolean addAtLast(E e) {
    Node newNode = new Node(e);
    if (isNull(head)) {
      head = newNode;
    } else {
      Node currentNode = head;
      while (nonNull(currentNode.next)) {
        currentNode = currentNode.next;
      }
      currentNode.next = newNode;
    }
    size++;
    return true;
  }

  public boolean addAtFirst(E e) {
    Node newNode = new Node(e);
    newNode.next = head;
    head = newNode;
    size++;
    return true;
  }

  public boolean removeAtFirst() {
    if (isNull(head)) {
      return false;
    }
    head = head.next;
    size--;
    return true;
  }

  public boolean removeAtLast() {
    if (isNull(head)) {
      return false;
    }
    if (isNull(head.next)) {
      head = null;
      size--;
      return true;
    }

    /* Node currentNode = head;  by two pointer approach
    Node previous = head;
    while (nonNull(currentNode.next)) {
        previous = currentNode;
        currentNode = currentNode.next;
    }
    previous.next = null;
    size--;
    return true;*/
    Node current = head;
    while (current.next.next != null) {
      current = current.next;
    }

    current.next = null;
    size--;
    return true;
  }

  public boolean removeAt(int index) {
    if (size <= index) {
      return false;
    }
    if (index == 0) {
      return removeAtFirst();
    }
    if (index == size - 1) {
      return removeAtLast();
    }
    int count = 0;
    Node currentNode = head;
    Node previousNode = head;
    while (nonNull(currentNode) && (count != index)) {
      previousNode = currentNode;
      currentNode = currentNode.next;
      count++;
    }
    previousNode.next = currentNode.next;
    size--;
    return true;
  }

  public String toString() {
    StringJoiner joiner = new StringJoiner(",", "[", "]");
    Node currentNode = head;
    while (nonNull(currentNode)) {
      joiner.add(String.valueOf(currentNode.data));
      currentNode = currentNode.next;
    }
    return joiner.toString();
  }

  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addAtLast(1);
    linkedList.addAtLast(2);
    linkedList.addAtFirst(0);
    linkedList.addAtLast(3);
    linkedList.addAtFirst(-1);
    System.out.println(linkedList.size);
    System.out.println(linkedList);
    //        linkedList.removeAtFirst();
    //        System.out.println(linkedList.size);
    //        System.out.println(linkedList);
    linkedList.removeAtLast();
    //        System.out.println(linkedList.size);
    //        System.out.println(linkedList);
    // linkedList.removeAt(4);
    System.out.println(linkedList.size);
    System.out.println(linkedList);
  }
}
