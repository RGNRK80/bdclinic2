package by.vet.controller;

import by.vet.dao.exception.DAOConnectEx;
import by.vet.dao.exception.DAONotAddedUserExeption;
import by.vet.dto.RegUserDataDTO;
import by.vet.entity.Role;
import by.vet.entity.Status;
import by.vet.service.impl.ServiceImpl;
import by.vet.validator.Validator;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {

        String url ="jdbc:mysql://localhost:3306/vetclinic";
        String user="root";
        String pass="dd286082";

        ServiceImpl service= null;
        try {
            service = new ServiceImpl(url,user,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //регистрация

        RegUserDataDTO regUserDataDTO = new RegUserDataDTO();
        regUserDataDTO.setLogin_tel("+375 00 0 000 005");
        regUserDataDTO.setEmail("DJ1@pirates.com");
        regUserDataDTO.setName("Davy");
        regUserDataDTO.setSurname("Jones1");
        regUserDataDTO.setPass("adf");
        regUserDataDTO.setRole(Role.CUSTOMER);
        regUserDataDTO.setStatus(Status.NEW);



     //   System.out.println(service.addNewUser(regUserDataDTO));
        System.out.println("email " + Validator.emailPatternMatches(regUserDataDTO.getEmail()));
        System.out.println("pass "+Validator.passPatternMatches("1As!wewewewe"));






    }
}