package java8Fetaure;

import dataStructure.list.doublylinkedlist.LinkedList;

import java.util.stream.Stream;

public class StreamClass {

    static void main() {
        Stream<String> stream =
                Stream.of("a", "b", "c");
     // Stream ss=  stream.map(String::toUpperCase);
        System.out.println(stream);
       // System.out.println(ss);
        stream.distinct().forEach(System.out::println);
    }
}
