package by.vetclinic.service;

import by.vetclinic.dao.DAOwork;

import java.sql.SQLException;

public class Service {
    DAOwork daOwork=new DAOwork();

        public boolean connect(String url, String log, String pass) throws SQLException {
        return daOwork.connect(url, log, pass);

    }


}
