package by.vetclinic.dao;

import by.vetclinic.entity.Customer;
import by.vetclinic.entity.Doctor;
import by.vetclinic.entity.Pet;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAOworkServ  {
    boolean connect(String url, String pass, String log) throws SQLException;

    Doctor addNewDoc(Doctor doc);
    Doctor setDoc(Doctor doc);
    Doctor delDoc(Doctor doc);
    Doctor getDocId (int id);
    ArrayList<Doctor> getDocByName (String name);
    ArrayList<Doctor> getDocSurName (String surname);
    ArrayList<Doctor> getDocbyPet (Pet pet);

    Customer addNewCustomer(Customer customer);//добавление
    Customer setCustomer(Customer customer);//изменение

    ArrayList<Customer> getCustomerByName (String name);
    ArrayList<Customer> getCustomerBySurName (String surname);
    ArrayList<Customer> getCustomerByPet (Pet pet);
    Customer getCustomerByid (int id);


    Pet addNewPet(Pet pet);
    Pet setPet(Pet pet);
    ArrayList<Pet> getPetbyName (String name);
    ArrayList<Pet> getPetbyType (String type);
    Pet getPetbyid (int id);




}
