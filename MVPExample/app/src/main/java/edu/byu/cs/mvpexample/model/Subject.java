package edu.byu.cs.mvpexample.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    public interface Observer {
        void update();
    }

    private List<Observer> observerList;

    public Subject() {
        observerList = new ArrayList<>();
    }

    public void register(Observer o) {
        observerList.add(o);
    }

    public void unregister(Observer o) {
        observerList.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observerList) {
            o.update();
        }
    }
}
