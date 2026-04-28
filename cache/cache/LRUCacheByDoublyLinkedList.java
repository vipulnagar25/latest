package cache;

import java.util.HashMap;

public class LRUCacheByDoublyLinkedList {
  private static class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private final int capacity;
  private final HashMap<Integer, Node> map;
  private final Node head;
  private final Node tail;

  public LRUCacheByDoublyLinkedList(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>();
    head = new Node(-1, -1);
    tail = new Node(-1, -1);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    Node node = map.get(key);
    remove(node);
    insertAtHead(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      node.value = value;
      remove(node);
      insertAtHead(node);
    } else {
      if (map.size() == capacity) {
        map.remove(tail.prev.key);
        remove(tail.prev);
      }
      Node newNode = new Node(key, value);
      map.put(key, newNode);
      insertAtHead(newNode);
    }
  }

  private void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void insertAtHead(Node node) {
    node.next = head.next;
    node.next.prev = node;
    head.next = node;
    node.prev = head;
  }

  static void main() {
    var cache = new LRUCacheByDoublyLinkedList(3);
    cache.put(1, 1);
    cache.put(3, 3);
    cache.put(2, 2);
    System.out.println(cache.map);
    System.out.println("==============");
    System.out.println(cache.get(3));
    System.out.println(cache.map);
    System.out.println(cache.head);
  }
}
