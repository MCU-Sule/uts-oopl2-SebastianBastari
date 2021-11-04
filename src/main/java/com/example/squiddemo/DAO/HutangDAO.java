package com.example.squiddemo.DAO;
/**
 * Sebastian 1972006
 */
import com.example.squiddemo.Entity.Hutang;
import com.example.squiddemo.Entity.Player;
import com.example.squiddemo.Utility.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HutangDAO implements DAOinterface<Hutang>{
    @Override
    public int addData(Hutang data) throws SQLException {
        int result = 0;
        try {
            String query = "INSERT INTO hutang (PemberiUtang,Jumlah,Player_id) VALUES (?,?,?)";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setString(1,data.getPemberiUtang());
            ps.setDouble(2,data.getJumlah());
            ps.setInt(3,data.getPlayer().getId());
            result = ps.executeUpdate();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        return result;
    }

    @Override
    public int delData(Hutang data) throws SQLException {
        int result = 0;
        try {
            String query = "DELETE FROM hutang where id=?";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setInt(1,data.getId());
            result = ps.executeUpdate();


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public int updateData(Hutang data) {
        int result = 0;
        try {
            String query = "UPDATE hutang set PemberiUtang = ? ,Jumlah =? , player_id = ?   WHERE id = ? ";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setString(1, data.getPemberiUtang());
            ps.setDouble(2, data.getJumlah());
            ps.setInt(3, data.getPlayer().getId());
            ps.setInt(4, data.getId());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public ObservableList<Hutang> showData() {
        ObservableList<Hutang> hutangs = FXCollections.observableArrayList();
        try {
            String query = "SELECT h.id AS id, h.PemberiUtang AS PemberiUtang, h.Jumlah AS Jumlah, p.id AS Player_id FROM hutang h INNER JOIN player p ON h.Player_id = p.id";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet res = ps.executeQuery();
            while (res.next()){
                int playerId = res.getInt("player_id");
                Player player = new Player();
                player.setId(playerId);
                Hutang hutang = new Hutang();
                hutang.setId(res.getInt("id"));
                hutang.setPemberiUtang(res.getString("PemberiUtang"));
                hutang.setJumlah(res.getDouble("jumlah"));
                hutang.setPlayer(player);
                hutangs.add(hutang);
            }
        } catch (SQLException exception){
            System.out.println(exception.getMessage());
        }


        return hutangs;
    }
}
