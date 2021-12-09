package by.vetclinic.service;

import by.vetclinic.dao.DAOwork;
import by.vetclinic.entity.Role;
import lombok.Data;

import java.sql.Connection;
import java.sql.SQLException;

@Data
public class EnterService {
    String url;
    String log;
    String pass;
    DAOwork daOwork;
    Connection connection;

    public EnterService (String url,String log,String pass) throws SQLException {
        this.url =url;
        this.log=log;
        this.pass=pass;
        daOwork=new DAOwork(url, log, pass);
        System.out.println("s " +this.url);
        System.out.println("s "+this.log);
        System.out.println("s "+this.pass);
        // daOwork.connect(url, log, pass);
        // daOwork.setConnection(connection);

    }

    public Role getRole (String login, String pass) {
        Role role = null;
        return role;
    }

}
