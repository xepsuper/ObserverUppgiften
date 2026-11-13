package com.ad.controllers;

import com.ad.communication.NetworkRetriever;
import com.ad.interfaces.IControllerWithLifeCycle;
import com.ad.interfaces.IObserver;
import com.ad.interfaces.ISubject;
import com.ad.models.Stock;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sw.IStock;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TableController implements Initializable, IControllerWithLifeCycle, IObserver {

    @FXML
    private TableView<Stock> tbData;
    @FXML
    public TableColumn<Stock, String> name_cell;
    @FXML
    public TableColumn<Stock, Integer> price_cell;

    private ObservableList<Stock> stockData = FXCollections.observableArrayList(new Stock("No data retrieved yet!", 0.0));
    private ISubject subject;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupTableColumnLink();

         subject = NetworkRetriever.getNetworkRetriever();
        subject.register(this);
    }

    private void setupTableColumnLink() {
        name_cell.setCellValueFactory(new PropertyValueFactory<>("Name"));
        price_cell.setCellValueFactory(new PropertyValueFactory<>("Price"));

        tbData.setItems(stockData);



    }

    // can be called to clear all data in table data source
    private void clearTable() {
        stockData.remove(0, stockData.size()); // quick and dirty
    }

    // can be called to populate table with data from a Stock array
    private void populateTableFromArray(ArrayList<Stock> stocks) {
        stockData.addAll(stocks);
    }

    @Override
    public void willUnmount() {
        System.out.println("Table Controller Will unmount!!");
        subject.unregister(this);
    }

    @Override
    public void update(List<IStock> message) {

        ArrayList<Stock> updatedStocks = new ArrayList<>();

        for (IStock stock : message) {
            updatedStocks.add(
                    new Stock(stock.getName(), stock.getPrice())
            );
        }

        Platform.runLater(() -> {
            clearTable();
            populateTableFromArray(updatedStocks);
        });
    }
}
