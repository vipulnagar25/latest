package dataStructure.list.singlelinkedlist;

import java.util.NoSuchElementException;

import static java.util.Objects.isNull;

public class Problem {

    public static Integer getMidElement(LinkedList<Integer> list) {
        if (isNull(list) || isNull(list.head)) {
            throw new NoSuchElementException("Cannot find the middle element of a null or empty list.");
        }

        Node slowPointer = list.head;
        Node fastPointer = list.head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return (Integer) slowPointer.data;
    }

    public static LinkedList reverse(LinkedList<Integer> list) {
        if (list == null || list.head == null) {
            return null;
        }
        Node currentNode = list.head;
        Node previousNode = null;

        while (currentNode != null) {
            Node next = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = next;
        }
        list.head = previousNode;
        return list;
    }

    public static LinkedList<Integer> removeDuplicatesFromSortedList(LinkedList<Integer> list) {
        if (list == null || list.head == null) {
            return list;
        }
        Node current = list.head;
        while (current.next != null) {
            if (current.data.equals(current.next.data)) {
                current.next = current.next.next;
                list.size--;
            } else {
                current = current.next;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addAtLast(1);
        list.addAtLast(2);
        list.addAtLast(3);
        System.out.println(list);
        System.out.println(reverse(list).toString());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        LinkedList<Integer> sortedList = new LinkedList<>();
        sortedList.addAtLast(1);
        sortedList.addAtLast(1);
        sortedList.addAtLast(2);
        sortedList.addAtLast(2);
        sortedList.addAtLast(3);
        sortedList.addAtLast(3);
        System.out.println(sortedList);
        LinkedList<Integer> uniqueList = removeDuplicatesFromSortedList(sortedList);
        System.out.println(uniqueList);
        System.out.println(getMidElement(uniqueList));

    }
}
