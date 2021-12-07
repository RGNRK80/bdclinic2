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
        Service service=new Service();

        System.out.println("Connection is " + service.connect(url,user,pass));

        String name="GorgiaГрузия";
       // name.chars().filter(n->Character.isLetter(n)).forEach(System.out::println);

        //добавляем пользователя
        // регистрация в БД
        //service.addNewCustomer();








    }//psvm
}//main
