package by.vetclinic.controller;

import by.vetclinic.dao.DAOwork;
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
        service.addNewCustomer("John3","Smith3","JS3@mail.ru","+375004","11111");
        service.addNewDoc("Aibo","lite","AL1@mail.doc","+375011","11111", "vet_1_cat");












    }//psvm
}//main
