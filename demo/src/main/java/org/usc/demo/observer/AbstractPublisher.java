package org.usc.demo.observer;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author ShunLi
 */
public class AbstractPublisher extends Observable implements Publisher {
    public void publish() {
        setChanged();
        notifyObservers();
    }

    public void publish(Object arg) {
        setChanged();
        notifyObservers(arg);
    }

    public void addObservers(List<? extends Observer> observers) {
        for (Observer observer : observers) {
            addObserver(observer);
        }
    }
}
