package com.ad.interfaces;

import sw.IStock;

import java.util.List;
import java.util.Observer;

public interface ISubject {
    void register(IObserver observer);

    void unregister(IObserver observer);
}