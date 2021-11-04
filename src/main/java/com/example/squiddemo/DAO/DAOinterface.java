package com.example.squiddemo.DAO;
/**
 * Sebastian 1972006
 */
import java.sql.SQLException;
import java.util.List;

public interface DAOinterface <E> {
    public int addData(E data) throws SQLException;

    public int delData(E data) throws SQLException;

    public int updateData(E data);

    public List<E> showData();

}
