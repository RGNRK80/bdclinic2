package by.vet.service.impl;

import by.vet.dao.exception.DAOConnectEx;
import by.vet.dao.exception.DAONotAddedUserExeption;
import by.vet.dao.exception.DaoUserExistException;
import by.vet.dao.impl.DAOWork;
import by.vet.dto.*;
import by.vet.entity.Pet;
import by.vet.entity.Role;
import by.vet.entity.Status;
import by.vet.service.ServInterface;
import by.vet.validator.Validator;


import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceImpl implements ServInterface {
    String url;
    String log;
    String pass;
    DAOWork dw;

    public ServiceImpl (String url,String log,String pass)  {
        this.url =url;
        this.log=log;
        this.pass=pass;
        dw=new DAOWork(url, log, pass);
    }

    @Override
    public UserDataDTO addNewUser (RegUserDataDTO user) throws DaoUserExistException, DAOConnectEx {
        UserDataDTO userDataDTO=null;
       // System.out.println(Validator.validateRegData(user));
        if (Validator.validateRegData(user)) {userDataDTO=dw.addNewUser(user);}
       return userDataDTO;
    }
    @Override
    public UserDataDTO enter (EnterDTO user) {
        UserDataDTO userDataDTO=null;
        if (Validator.loginVal(user.getLogin()) && Validator.passVal(user.getPass())) {
            userDataDTO=dw.enter(user);
        }
        if (userDataDTO.getLogin()==null) {userDataDTO=null;}
        if (userDataDTO.getStatus()== Status.CLOSED) {userDataDTO=null;}
         return userDataDTO;
    }
    @Override
    public PetDataDTO addNewPet(RegPetDataDTO regpet) {
        PetDataDTO petDataDTO=null;
        if (Validator.nameVal(regpet.getName()) && Validator.nameVal(regpet.getType())) {
        petDataDTO=dw.addNewPet(regpet);}
        return petDataDTO;
    }
    @Override
    public ArrayList<Pet> getPets(UserDataDTO userDataDTO){
        ArrayList<Pet> ar= new ArrayList<>();
        ar=null;
        ar=dw.getPets(userDataDTO);
        return ar;

    }
    @Override
    public ArrayList<Pet> getZPets(UserDataDTO userDataDTO){
        ArrayList<Pet> ar= new ArrayList<>();
        ar=null;
        if (userDataDTO.getRole()== Role.DOCTOR && userDataDTO.getStatus()==Status.ACTIVE){
        ar=dw.getZPets();}
        return ar;
    }

    @Override
    public PetDataDTO getDocToPet (UserDataDTO userDataDTO,long idpet){
        PetDataDTO pet = null;
        if (userDataDTO.getRole()== Role.DOCTOR && userDataDTO.getStatus()==Status.ACTIVE){
            pet=dw.getDocToPet(userDataDTO.getId(), idpet);}
        return pet;
    }


}
