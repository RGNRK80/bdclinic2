package by.vet.controller;

import by.vet.dao.exception.DAONotAddedUserExeption;
import by.vet.dto.RegUserDataDTO;
import by.vet.entity.Role;
import by.vet.entity.Status;
import by.vet.service.impl.ServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, DAONotAddedUserExeption {

        String url ="jdbc:mysql://localhost:3306/vetclinic";
        String user="root";
        String pass="dd286082";

        ServiceImpl service=new ServiceImpl(url,user,pass);

        //регистрация

        RegUserDataDTO regUserDataDTO = new RegUserDataDTO();
        regUserDataDTO.setLogin_tel("+375 00 0 000 005");
        regUserDataDTO.setEmail("DJ1@pirates.com");
        regUserDataDTO.setName("Davy");
        regUserDataDTO.setSurname("Jones1");
        regUserDataDTO.setPass("1111");
        regUserDataDTO.setRole(Role.CUSTOMER);
        regUserDataDTO.setStatus(Status.NEW);
        service.addNewUser(regUserDataDTO);





    }
}
