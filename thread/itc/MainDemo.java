package thread.itc;

import java.util.LinkedList;
import java.util.Queue;

public class MainDemo {
    static void main() {
        Queue sharedQ = new LinkedList();
        Producer producer = new Producer(sharedQ);
        Consumer consumer = new Consumer(sharedQ);
        producer.start();
        consumer.start();
    }
}
