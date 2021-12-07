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
        service.addNewCustomer("John","Smith","JS@mail.ru","+375001","11111");













    }//psvm
}//main
