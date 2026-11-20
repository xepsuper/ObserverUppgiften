module textinserter {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires textinserter;

    opens controllers;
    opens files;
    opens textinserter;
}