package dataStructure.queue;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.StringJoiner;

public class Queue<E> {
    final static int DEFAULT_CAPACITY = 10;
    int size;
    Object[] elementData;

    public Queue() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public boolean add(E e) {
        if (size == elementData.length) {
            int newCapacity = increaseCapacity();
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
        elementData[size++] = e;
        return true;
    }

    public E remove() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E evictData = (E) elementData[0];
        Object[] newElements = new Object[size];
        int j = 0;
        for (int i = 1; i < size; i++) {
            newElements[j++] = elementData[i];
        }
        size--;
        elementData = newElements;
        return evictData;

    }

    private int increaseCapacity() {
        return size + size << 1;
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        for (int i = 0; i < size; i++) {
            joiner.add(String.valueOf(elementData[i]));
        }
        return joiner.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
    }
}
