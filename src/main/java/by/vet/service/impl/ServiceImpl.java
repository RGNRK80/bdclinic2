package by.vet.service.impl;

import by.vet.dao.impl.DAOWork;
import by.vetclinic.dao.DAOwork;

import java.sql.SQLException;

public class ServiceImpl {
    String url;
    String log;
    String pass;
    DAOwork dw;

    public ServiceImpl (String url,String log,String pass) throws SQLException {
        this.url =url;
        this.log=log;
        this.pass=pass;
        dw=new DAOwork(url, log, pass);
        System.out.println("s " +this.url);
        System.out.println("s "+this.log);
        System.out.println("s "+this.pass);
    }

}
