package com.inkspac3.observer;


public interface ArrayObservable {
    void registerObserver(ArrayObserver observer);
    void removeObserver(ArrayObserver observer);
    void notifyObservers();
}
