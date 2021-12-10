package by.vetclinic.controller;

import by.vetclinic.dao.DAOwork;
import by.vetclinic.entity.Customer;
import by.vetclinic.entity.Doctor;
import by.vetclinic.entity.Pet;
import by.vetclinic.entity.Role;
import by.vetclinic.service.CustomerService;
import by.vetclinic.service.DoctorService;
import by.vetclinic.service.EnterService;
import by.vetclinic.service.Service;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // соединение с БД
        // подключение

       String url ="jdbc:mysql://localhost:3306/mydbclinic";
        String user="root";
        String pass="dd286082";
        /*
        Service service=new Service(url,user,pass);*/

        //service.addNewCustomer("John6","Smith6","JS6@mail.ru","+3750056","11111");
        //service.addNewDoc("Aibo4","lite4","AL4@mail.doc","+37501114","111114", "vet_1_cat");
       // Customer cus1 = service.getCustomerById(2);
        //cus1.setSurname("Week");

       // service.setCustomer(cus1);
      // Doctor doc1 =  service.getDocById(5);
      // doc1.setPosition("mainsister");
      // service.setDoc(doc1);
      //System.out.println(service.getDocById(5));
       // System.out.println("проверка сервиса: " + service.getDocByName("Aibo2"));
       /* Pet pet=new Pet();
        pet.setName("Bro");
        pet.setType("Parrot");
        pet.setAge(2);
        pet.setSex("m");
        pet.setDateInn("2021-10-01");
        System.out.println(service.addNewPet(pet));*/

      /*   1. выбрать - ввести логин/пароль или добавить пользователя.
         если добавить пользователя - сервис- добавить пользователя
         если логин пароль  - запустить сервис входа - ввести логин и пароль -

         сервис входа выдаст роль
        в зависимости от роли создаем service доктора или заказчика

        Условно - админ это доктор с ролью админ и должностью админ.
        доктор - по суть класс работника клиники.

         Добавить Пользователя  */


        String login="";
        String password="";

        EnterService enterService=new EnterService(url,user,pass);
        enterService.addNewCustomer("Sam","Champlu","SC6@mail.com","+37500561","11111");



        if (enterService.getRole(login,password)== Role.ADMIN) {
        Service service=new Service(url,user,pass);

        }
        if (enterService.getRole(login,password)== Role.DOCTOR){
               //DoctorService service =new DoctorService(url,user,pass);
        }
        if (enterService.getRole(login,password)== Role.CUSTOMER) {
              // CustomerService service= new CustomerService(url,user,pass);
        }


        // по итогу у нас service с функициями заданной роли.

       //добавить в таблицу таки админа
       // email должен быть уникальным для всех таблиц




    }//psvm
}//main
