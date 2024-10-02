package behavioral;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

public class ObserverPattern {
    public static void execute() {
        Subject subject = new Subject();
        Observer varun = new ConcreteObserver("Varun");
        Observer gowtham = new ConcreteObserver("Gowtham");

        subject.registerObserver(varun);
        subject.registerObserver(gowtham);

        subject.notifyObservers("Hello Observers!");
    }
}
