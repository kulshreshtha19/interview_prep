package Patterns.Behavioural.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    List<Observer> observer;
    public Subject() {
        observer = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        this.observer.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observer.remove(observer);
    }

    public void notifyObservers(String weather) {
        for (Observer observer : observer) {
            observer.update(weather);
        }
    }
}
