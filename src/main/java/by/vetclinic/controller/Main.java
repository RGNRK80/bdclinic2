package by.vetclinic.controller;

import by.vetclinic.dao.DAOwork;
import by.vetclinic.entity.Customer;
import by.vetclinic.service.Service;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // соединение с БД
        // подключение

        String url ="jdbc:mysql://localhost:3306/mydbclinic";
        String user="root";
        String pass="dd286082";

        Service service=new Service(url,user,pass);
        //service.addNewCustomer("John6","Smith6","JS6@mail.ru","+3750056","11111");
       // service.addNewDoc("Aibo3","lite3","AL3@mail.doc","+37501113","111112", "vet_1_cat");
        Customer cus1 = service.getCustomerById(2);
        cus1.setSurname("Week");

        service.setCustomer(cus1);










    }//psvm
}//main
