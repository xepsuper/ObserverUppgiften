module com.ad.stocks {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires javafx.graphics;

    requires StockWatcher;


    opens com.ad.stocks to javafx.fxml;
    opens com.ad.controllers to javafx.fxml;
    opens com.ad.models to javafx.fxml;
    exports com.ad.stocks;
    exports com.ad.controllers;
    exports com.ad.models;
    exports com.ad.interfaces;
    opens com.ad.interfaces to javafx.fxml;
}