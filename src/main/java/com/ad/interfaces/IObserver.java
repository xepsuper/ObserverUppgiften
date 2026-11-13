package com.ad.interfaces;

import sw.IStock;

import java.util.List;

public interface IObserver {
    void update(List<IStock> message);
}
