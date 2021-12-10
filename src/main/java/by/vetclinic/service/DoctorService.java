package by.vetclinic.service;

import by.vetclinic.dao.DAOwork;

import java.sql.Connection;
import java.sql.SQLException;

public class DoctorService {
    private String url;
    private String log;
    private String pass;
    private DAOwork daOwork;
    private Connection connection;

    public DoctorService (String url,String log,String pass) throws SQLException {
        this.url =url;
        this.log=log;
        this.pass=pass;
        daOwork=new DAOwork(url, log, pass);
        System.out.println("s " +this.url);
        System.out.println("s "+this.log);
        System.out.println("s "+this.pass);
    }
}
