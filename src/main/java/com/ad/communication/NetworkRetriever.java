package com.ad.communication;

import sw.IStock;
import sw.IStockRetriver;
import sw.StockWatcher;

import java.util.List;

/**
 * This class will get notified when new stock prices are available.
 * new prices will arrive as an ArrayList to the dataInc method.
 * It's your job to make sure that the data is then distributed to all
 * interested parties (classes) in the application.
 *
 * As you see below a Singleton pattern is present, it's perfectly fine to use
 * this to gain easy acces in the application.
 * BUT if you do, remember you still have to add all expected abstractions for
 * the pattern you are asked to implement (even if you don't call on them
 * consistently).
 *
 * It is also perfectly fine to ignore/remove the singelton solution if you want
 * too setup connections to this class in some other way.
 */
public class NetworkRetriever implements IStockRetriver {

    private static NetworkRetriever SINGELTON;

    private NetworkRetriever() {
        // Start watching stock prices online!
        new StockWatcher(this);
    }

    public static NetworkRetriever getNetworkRetriever() {
        if (SINGELTON == null) {
            SINGELTON = new NetworkRetriever();
        }

        return SINGELTON;
    }

    // This method gets called when new stock prices are available.
    @Override
    public void dataInc(List<IStock> StockData) {System.out.println(StockData);}
}
