package com.ad.controllers;

import com.ad.interfaces.IControllerWithLifeCycle;
import com.ad.models.Stock;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TableController implements Initializable, IControllerWithLifeCycle {

    @FXML
    private TableView<Stock> tbData;
    @FXML
    public TableColumn<Stock, String> name_cell;
    @FXML
    public TableColumn<Stock, Integer> price_cell;

    private final ObservableList<Stock> stockData = FXCollections.observableArrayList(new Stock("No data retrieved yet!", 0.0));


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupTableColumnLink();

        clearTable();

        stockData.add(new Stock("AAPL", 150.0));
        stockData.add(new Stock("GOOGL", 2800.0));
        populateTableFromArray((ArrayList<Stock>) stockData);

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
    }
}
