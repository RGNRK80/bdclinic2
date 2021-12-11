package by.vet.dao.impl;

import by.vet.dao.exception.DAOConnectEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOWork {
    private Connection connection;
    private String url;
    private String log;
    private String pass;

    public DAOWork (String url, String log, String pass) throws SQLException {
        this.url = url;
        this.log = log;
        this.pass = pass;
    }

    public Connection connect() throws DAOConnectEx {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(url, log, pass);
        } catch (SQLException e)
        {
            throw new DAOConnectEx("...not connected...");
        }
        return connect;
    }
}
