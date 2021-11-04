package com.example.squiddemo.controller;
import com.example.squiddemo.DAO.HutangDAO;
import com.example.squiddemo.DAO.PlayerDAO;
import com.example.squiddemo.Entity.Hutang;
import com.example.squiddemo.Entity.Player;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
/**
 * Sebastian 1972006
 */
public class SquidController implements Initializable {
    @FXML
    private TableView<Player> tablePemain;

    @FXML
    private TableColumn<Player, String> colid;

    @FXML
    private TableColumn<Player, String> colnama;

    @FXML
    private TableColumn<Player, String> columur;

    @FXML
    private TableColumn<Player, String> colkemampuan;

    @FXML
    private Button btnadd;

    @FXML
    private Button btnedit;

    @FXML
    private Button btnhapus;

    @FXML
    private Button btntambahhutang;

    @FXML
    private ComboBox<Player> cmbPeserta;

    @FXML
    private TextField txtPemberiUtang;

    @FXML
    private TextField txtJumlah;

    @FXML
    private TableView<Hutang> tableHutang;

    @FXML
    private TableColumn<Hutang, String> colidpemain;

    @FXML
    private TableColumn<Hutang, String> colhutang;

    @FXML
    private TableColumn<Hutang, String> colsejumlah;

    @FXML
    private Button btnhapushutang;
    private ObservableList<Player> players;
    private ObservableList<Hutang> hutangs;
    private StageModalController controller;
    private PlayerDAO playerDAO;
    private HutangDAO hutangDAO;

    @FXML
    void shwadd(ActionEvent event) {

    }

    @FXML
    void shwedit(ActionEvent event) {

    }

    @FXML
    void shwhapus(ActionEvent event) {

    }
    @FXML
    void shwtambahhutang(ActionEvent event) throws SQLException {
        HutangDAO hutangDao = new HutangDAO();
        Hutang hutang = new Hutang();
        hutang.setPemberiUtang(txtPemberiUtang.getText());
        hutang.setJumlah(Double.valueOf(txtJumlah.getText()));
        hutang.setPlayer(cmbPeserta.getValue());
        hutangDAO.addData(hutang);
        hutangs.addAll(hutangDao.showData());
        hutangs.clear();
    }

    @FXML
    void shwhapushutang(ActionEvent event) throws SQLException {
        Hutang selected;
        selected = (Hutang)tableHutang.getSelectionModel().getSelectedItem();
        System.out.println(selected);
        HutangDAO dao = new HutangDAO();
        int result = dao.delData(selected);
        if(result != 0){
            System.out.println("Delete Succeed");
        }
        ObservableList<Hutang> list = dao.showData();
        tableHutang.setItems(list);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PlayerDAO playerDAO = new PlayerDAO();
        HutangDAO hutangDAO = new HutangDAO();
        players =  playerDAO.showData();
        tablePemain.setItems(players);
        cmbPeserta.setItems(players);
        hutangs = hutangDAO.showData();
        tableHutang.setItems(hutangs);
        colid.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getId())));
        colnama.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getNama())));
        columur.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getUmur())));
        colkemampuan.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getKeahlian())));
        colidpemain.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getPlayer().getId())));
        colhutang.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getPemberiUtang())));
        colsejumlah.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getJumlah())));
    }
    }


