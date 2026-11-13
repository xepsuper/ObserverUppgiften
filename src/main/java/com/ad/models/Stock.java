package com.ad.models;

import com.ad.interfaces.IObserver;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import sw.IStock;

import java.util.List;

public class Stock implements IStock {

    private SimpleDoubleProperty price;
    private SimpleStringProperty name;

    public Stock(String name, Double price) {          // ← unchanged
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
    }

    public String getName() {
        return name.get();
    }

    public Double getPrice() {
        return price.get();
    }

    public void setName(String n) {
        name.set(n);
    }

    public void setPrice(Double d) {
        price.set(d);
    }

    public String toString() {
        String var10000 = this.getName();
        return var10000 + " trading at: " + this.getPrice();
    }
}


