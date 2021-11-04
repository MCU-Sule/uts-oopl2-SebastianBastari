module com.example.squiddemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.squiddemo to javafx.fxml ;
    exports com.example.squiddemo;
    opens com.example.squiddemo.controller to javafx.fxml ;
    exports com.example.squiddemo.controller;
}