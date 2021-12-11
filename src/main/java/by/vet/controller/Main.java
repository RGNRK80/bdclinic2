package by.vet.controller;

import by.vet.service.impl.ServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        String url ="jdbc:mysql://localhost:3306/vetclinic";
        String user="root";
        String pass="dd286082";

        ServiceImpl service=new ServiceImpl(url,user,pass);


    }
}
