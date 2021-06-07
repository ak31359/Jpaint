package model;

import model.interfaces.Observable;
import model.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;


public class PaintObservable implements Observable {

    List<Observer> observerList = new ArrayList<Observer>();

    public PaintObservable() {
    }

    @Override
    public void addObserver(Observer observer) {
        if (!observerList.contains(observer)) {
            observerList.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyUpdate() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }

    @Override
    public void clear() {
        observerList.clear();
    }
}
