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

public class PlayerDAO implements DAOinterface<Player>{
    @Override
    public int addData(Player data) throws SQLException {
        int result = 0;
        try {
            String query = "INSERT INTO player (id,Nama,Umur,Keahlian) VALUES (?,?,?,?)";
            System.out.println("tes");
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setInt(1,data.getId());
            ps.setString(2,data.getNama());
            ps.setInt(3,data.getUmur());
            ps.setString(4,data.getKeahlian());
            result = ps.executeUpdate();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        return result;
    }

    @Override
    public int delData(Player data) throws SQLException {
        int result = 0;
        try {
            String query = "DELETE FROM player where id=?";
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
    public int updateData(Player data) {
        int result = 0;
        try {
            String query = "UPDATE player SET Nama = ? ,Umur = ? ,Keahlian = ?  WHERE id = ? ";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setString(1,data.getNama());
            ps.setInt(2,data.getUmur());
            ps.setString(3,data.getKeahlian());
            ps.setInt(4,data.getId());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public ObservableList<Player> showData() {
        ObservableList<Player> players = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM player";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet res = ps.executeQuery();
            while (res.next()){
                Player player = new Player();
                player.setId(res.getInt("id"));
                player.setNama(res.getString("Nama"));
                player.setUmur(res.getInt("Umur"));
                player.setKeahlian(res.getString("Keahlian"));
                players.add(player);
            }
        } catch (SQLException exception){
            System.out.println(exception.getMessage());
        }

        return players;
    }
    }

