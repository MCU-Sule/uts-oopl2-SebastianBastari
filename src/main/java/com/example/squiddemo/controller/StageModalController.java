package com.example.squiddemo.controller;
import com.example.squiddemo.DAO.PlayerDAO;
import com.example.squiddemo.Entity.Player;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * Sebastian 1972006
 */
public class StageModalController {
    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNama;

    @FXML
    private TextField txtUmur;

    @FXML
    private TextField txtKeahlian;

    @FXML
    private Button btnok;

    @FXML
    private Button btncancel;
    private PlayerDAO playerDAO ;
    private ObservableList<Player> players;
    private SquidController controller;

    public void setController (SquidController controller){

    }
    @FXML
    void shwcancel(ActionEvent event) {

    }

    @FXML
    void shwok(ActionEvent event) {

    }
}
