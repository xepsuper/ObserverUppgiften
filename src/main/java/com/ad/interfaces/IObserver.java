package com.ad.interfaces;

import com.ad.models.Stock;

public interface IObserver {
    void update(Stock data);
}
