package com.inkspac3.course.observer;


public interface ArrayObservable {
    void registerObserver(ArrayObserver observer);
    void removeObserver(ArrayObserver observer);
    void notifyObservers();
}
