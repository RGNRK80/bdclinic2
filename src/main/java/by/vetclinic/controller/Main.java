package by.vetclinic.controller;

import by.vetclinic.dao.DAOwork;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // соединение с БД
        // подключение

        String url ="jdbc:mysql://localhost:3306/mydbclinic";
        String user="root";
        String pass="dd286082";


        DAOwork dao = new DAOwork();
        System.out.println(dao.connect(url,user,pass));









    }//psvm
}//main
