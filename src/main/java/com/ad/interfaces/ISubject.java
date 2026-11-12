package com.ad.interfaces;

import java.util.Observer;

public interface ISubject {
    void register(IObserver observer);
    void unregister(IObserver observer);

    void notifyObservers(String message);
}
