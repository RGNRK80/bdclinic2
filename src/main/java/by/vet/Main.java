package by.vet;


import by.vet.dto.EnterDTO;
import by.vet.dto.RegPetDataDTO;
import by.vet.dto.RegUserDataDTO;
import by.vet.dto.UserDataDTO;
import by.vet.entity.Pet;
import by.vet.entity.Role;
import by.vet.entity.Status;
import by.vet.service.impl.ServiceImpl;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)  {
/*
        String url ="jdbc:mysql://localhost:3306/vetclinic";
        String user="root";
        String pass="dd286082";

        ServiceImpl service= null;*/
       // service = new ServiceImpl(url,user,pass);

        //регистрация
        RegUserDataDTO regUserDataDTO = new RegUserDataDTO();
        regUserDataDTO.setLogin_tel("+375 00 0 000 007");
        regUserDataDTO.setEmail("DJ7@pirates.com");
        regUserDataDTO.setName("Davyd");
        regUserDataDTO.setSurname("Joness");
        regUserDataDTO.setPass("Aa3587!adf");
        regUserDataDTO.setRole(Role.CUSTOMER);
        regUserDataDTO.setStatus(Status.NEW);

        // вход
/*        EnterDTO enterUser= new EnterDTO();
        enterUser.setLogin("+375 00 0 000 007");
        enterUser.setPass("Aa3587!adf");
        UserDataDTO userData = new UserDataDTO();
        userData = service.enter(enterUser);
        System.out.println(userData);
        // null если нет логина-пароля - изменить на exception

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


        // массив петов по пользователю c историей
        ArrayList<Pet> getPets =new ArrayList<Pet>();
        getPets=service.getPets(userData);

        //массив петов без доктора
        getPets=service.getZPets(userData);

        //акцепт доктора
        long idPet=3;
        service.getDocToPet(userData,idPet);

        //изменения состояния пета доктором




*/




    }
}
