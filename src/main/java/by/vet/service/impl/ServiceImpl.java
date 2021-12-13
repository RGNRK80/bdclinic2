package by.vet.service.impl;

import by.vet.dao.exception.DAONotAddedUserExeption;
import by.vet.dao.impl.DAOWork;
import by.vet.dto.RegUserDataDTO;
import by.vet.dto.UserDataDTO;


import java.sql.SQLException;

public class ServiceImpl {
    String url;
    String log;
    String pass;
    DAOWork dw;

    public ServiceImpl (String url,String log,String pass) throws SQLException {
        this.url =url;
        this.log=log;
        this.pass=pass;
        dw=new DAOWork(url, log, pass);
//        System.out.println("s " +this.url);
//        System.out.println("s "+this.log);
//        System.out.println("s "+this.pass);
    }

    public UserDataDTO addNewUser (RegUserDataDTO user) throws DAONotAddedUserExeption {
       UserDataDTO userDataDTO=dw.addNewUser(user);
       return userDataDTO;
    }

}
