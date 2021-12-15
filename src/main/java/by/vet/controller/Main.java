package by.vet.controller;

import by.vet.dao.exception.DAOConnectEx;
import by.vet.dao.exception.DAONotAddedUserExeption;
import by.vet.dto.EnterDTO;
import by.vet.dto.RegPetDataDTO;
import by.vet.dto.RegUserDataDTO;
import by.vet.dto.UserDataDTO;
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
        regUserDataDTO.setLogin_tel("+375 00 0 000 007");
        //System.out.println("tel " +Validator.loginVal("+375 00 0 000 007"));
        regUserDataDTO.setEmail("DJ7@pirates.com");
      //  System.out.println("mail " +Validator.emailVal( "DJ7@pirates.com"));
        regUserDataDTO.setName("Davyd");
      //  System.out.println("name "+Validator.nameVal( "Davyd"));
        regUserDataDTO.setSurname("Joness");
      //  System.out.println("surname " +Validator.nameVal( "Joness"));
        regUserDataDTO.setPass("Aa3587!adf");
      //  System.out.println("pass " +Validator.passVal( "Aa3587!adf"));
        regUserDataDTO.setRole(Role.CUSTOMER);
        regUserDataDTO.setStatus(Status.NEW);

      //  service.addNewUser(regUserDataDTO);


        // вход

        EnterDTO enterUser= new EnterDTO();
        enterUser.setLogin("+375 00 0 000 007");
        enterUser.setPass("Aa3587!adf");
        UserDataDTO userData = new UserDataDTO();

        userData = service.enter(enterUser);
        System.out.println(userData);
        // null если нет логина-пользователя и пароля

        //добавляем пета
        RegPetDataDTO regPet = new RegPetDataDTO();
        regPet.setName("Pirat");
        regPet.setType("Parrot");
        regPet.setSex("M");
        regPet.setIdCustomer(userData.getId());
        regPet.setDateInn("2020-01-30");
        regPet.setCondition("");
        regPet.setStatus(Status.NEW);
        service.addNewPet(regPet);










    }
}
