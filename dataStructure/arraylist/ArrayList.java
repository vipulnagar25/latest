package dataStructure.arraylist;

import java.util.Arrays;
import java.util.StringJoiner;

public class ArrayList<E> {
    final static int DEFAULT_CAPACITY = 10;
    int size;
    Object elementData[];

    ArrayList() {
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


    private int increaseCapacity() {
        return size + size << 1;
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            joiner.add(String.valueOf(elementData[i]));
        }
        return joiner.toString();
    }

    public static void main(String[] args) {
        //PECS good concept
        // ArrayList<? super Number> arrayList = new ArrayList();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        System.out.println(arrayList);
    }
}
