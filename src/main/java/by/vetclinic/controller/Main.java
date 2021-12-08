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
      //   service.addNewCustomer("John4","Smith4","JS4@mail.ru","+3750041","11111");
      //  service.addNewDoc("Aibo1","lite1","AL11@mail.doc","+3750111","11111", "vet_1_cat");
        System.out.println(service.getCustomerById(2).toString());











    }//psvm
}//main
