package dataStructure.stack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.StringJoiner;

public class Stack<E> {
    final static int DEFAULT_CAPACITY = 10;
    int size;
    Object elementData[];

    Stack() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public boolean push(E e) {
        if (size == elementData.length) {
            int newCapacity = increaseCapacity();
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
        elementData[size++] = e;
        return true;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return (E) elementData[--size];
    }

    private int increaseCapacity() {
        return size + size << 1;

    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        for (int i = size - 1; i >= 0; i--) {
            joiner.add(String.valueOf(elementData[i]));
        }
        return joiner.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        System.out.println(stack.size);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.size);

    }
}
