package designPattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

interface Subject {
    void subscribe(Observer o);

    void unsubscribe(Observer o);

    void notifyObservers();
}


class YouTubeChannel implements Subject {
    private List<Observer> subscribers = new ArrayList<>();
    private String videoTitle;

    public void subscribe(Observer o) {
        subscribers.add(o);
    }

    public void unsubscribe(Observer o) {
        subscribers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : subscribers) {
            o.update(videoTitle);
        }
    }

    public void uploadVideo(String title) {
        this.videoTitle = title;
        notifyObservers();
    }
}

class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void update(String videoTitle) {
        System.out.println(name + " got notification: New video uploaded - " + videoTitle);
    }
}

/**
 * Observer Pattern is a behavioral design pattern where one object
 * (Subject) maintains a list of dependents (Observers)
 * and notifies them automatically whenever its state changes.
 */
public class ObserverDemo {
    static void main() {
        YouTubeChannel channel = new YouTubeChannel();

        Observer user1 = new Subscriber("Vipul");
        Observer user2 = new Subscriber("Amit");
        Observer user3 = new Subscriber("Vladimir");

        channel.subscribe(user1);
        channel.subscribe(user2);
        channel.subscribe(user3);

        channel.uploadVideo("Observer Pattern in Java");
    }
}
