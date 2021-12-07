package by.vetclinic.dao;

import by.vetclinic.entity.Customer;
import by.vetclinic.entity.Doctor;
import by.vetclinic.entity.Pet;
import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

@Data
public class DAOwork {
    private Connection connection;

    public DAOwork(String url, String log, String pass) throws SQLException {
        this.connection = DriverManager.getConnection(url,log,pass);
    }

   /* @Override
    public void connect(String url, String log, String pass) throws SQLException {
        System.out.println(url);
        System.out.println(log);
        System.out.println(pass);
        this.connection= DriverManager.getConnection(url,log,pass);
        System.out.println(!connection.isClosed());

    }  */

/*
    @Override
    public Doctor addNewDoc(Doctor doc) {
        return null;
    }

    @Override
    public Doctor setDoc(Doctor doc) {
        return null;
    }

    @Override
    public Doctor delDoc(Doctor doc) {
        return null;
    }

    @Override
    public Doctor getDocId(int id) {
        return null;
    }

    @Override
    public ArrayList<Doctor> getDocByName(String name) {
        return null;
    }

    @Override
    public ArrayList<Doctor> getDocSurName(String surname) {
        return null;
    }

    @Override
    public ArrayList<Doctor> getDocbyPet(Pet pet) {
        return null;
    }
*/
   //@Override
    public Customer addNewCustomer(Customer customer) throws SQLException {



        String insert = "INSERT INTO customer VALUES(0,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1,customer.getName());
        preparedStatement.setString(2,customer.getSurname());
        preparedStatement.setString(3,customer.getTel());
        preparedStatement.setString(4,customer.getEmail());
        preparedStatement.setString(5,customer.getPass());
        preparedStatement.executeUpdate();





        return null;
    }
/*
    @Override
    public Customer setCustomer(Customer customer) {
        return null;
    }

    @Override
    public ArrayList<Customer> getCustomerByName(String name) {
        return null;
    }

    @Override
    public ArrayList<Customer> getCustomerBySurName(String surname) {
        return null;
    }

    @Override
    public ArrayList<Customer> getCustomerByPet(Pet pet) {
        return null;
    }

    @Override
    public Customer getCustomerByid(int id) {
        return null;
    }

    @Override
    public Pet addNewPet(Pet pet) {
        return null;
    }

    @Override
    public Pet setPet(Pet pet) {
        return null;
    }

    @Override
    public ArrayList<Pet> getPetbyName(String name) {
        return null;
    }

    @Override
    public ArrayList<Pet> getPetbyType(String type) {
        return null;
    }

    @Override
    public Pet getPetbyid(int id) {
        return null;
    }
*/
}