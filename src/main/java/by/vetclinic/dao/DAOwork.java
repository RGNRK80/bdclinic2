package by.vetclinic.dao;

import by.vetclinic.entity.Customer;
import by.vetclinic.entity.Doctor;
import by.vetclinic.entity.Pet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOwork implements DAOworkServ{


    @Override
    public boolean connect(String url, String pass, String log) throws SQLException {
        String rezult;
        Connection connection= DriverManager.getConnection(url,log,pass);
        return connection.isClosed();
    }

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

    @Override
    public Customer addNewCustomer(Customer customer) {
        return null;
    }

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

}