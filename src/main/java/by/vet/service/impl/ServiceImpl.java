package by.vet.service.impl;

import by.vet.dao.exception.DAOConnectEx;
import by.vet.dao.exception.DAONotAddedUserExeption;
import by.vet.dao.impl.DAOWork;
import by.vet.dto.*;
import by.vet.entity.Status;
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
       // System.out.println(Validator.validateRegData(user));
        if (Validator.validateRegData(user)) {userDataDTO=dw.addNewUser(user);}
       return userDataDTO;
    }

    public UserDataDTO enter (EnterDTO user) {
        UserDataDTO userDataDTO=null;
        if (Validator.loginVal(user.getLogin()) && Validator.passVal(user.getPass())) {
            userDataDTO=dw.enter(user);
        }
        if (userDataDTO.getLogin()==null) {userDataDTO=null;}
        if (userDataDTO.getStatus()== Status.CLOSED) {userDataDTO=null;}
         return userDataDTO;
    }

    public PetDataDTO addNewPet(RegPetDataDTO regpet) {
        PetDataDTO petDataDTO=null;
        petDataDTO=dw.addNewPet(regpet);
        return petDataDTO;
            }

}
