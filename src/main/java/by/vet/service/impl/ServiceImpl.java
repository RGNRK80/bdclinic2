package by.vet.service.impl;

import by.vet.dao.exception.DAOConnectEx;
import by.vet.dao.exception.DAONotAddedUserExeption;
import by.vet.dao.impl.DAOWork;
import by.vet.dto.RegUserDataDTO;
import by.vet.dto.UserDataDTO;
import by.vet.validator.Validator;


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
    }

    public UserDataDTO addNewUser (RegUserDataDTO user) {
        UserDataDTO userDataDTO=null;
        if (Validator.validateRegData(user)) {userDataDTO=dw.addNewUser(user);}
       return userDataDTO;
    }

}
