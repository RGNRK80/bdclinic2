package by.vetclinic.service;

import by.vetclinic.dao.DAOwork;
import by.vetclinic.entity.Customer;
import by.vetclinic.entity.Doctor;
import by.vetclinic.entity.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Service {
    String url;
    String log;
    String pass;
    DAOwork daOwork;
    Connection connection;

    public Service (String url,String log,String pass) throws SQLException {
        this.url =url;
        this.log=log;
        this.pass=pass;
        daOwork=new DAOwork(url, log, pass);
        System.out.println("s " +this.url);
        System.out.println("s "+this.log);
        System.out.println("s "+this.pass);
       // daOwork.connect(url, log, pass);
       // daOwork.setConnection(connection);

    }

    public void addNewCustomer(String name, String surname, String email, String tel, String pass) throws SQLException {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setSurname(surname);
            customer.setEmail(email);
            customer.setTel(tel);
            customer.setPass(pass);

        //  Boolean checkName=name.matches("[^a-zA-Zа-яА-я]");
        //  Boolean checkSurName=surname.matches("[^a-zA-Zа-яА-я]");
        //  Boolean checkEmail=email.matches("\\D");
        //   Boolean checktel=tel.matches("\\D");
        //  Boolean checkPass=email.matches();  //   ^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$
        // https://web.izjum.com/regexp-email-url-phone
        // чекнуть правильность всех граф
        // если ок соединяемся с бд и чекаем email и тел по базе
        // запрос в бд на наличие email и телефона
        // если все ок
        // добавляем customer
        daOwork.addNewCustomer(customer);
    }

    public Doctor addNewDoc (String name, String surname, String email, String tel, String pass, String position) throws SQLException {
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setSurname(surname);
        doctor.setEmail(email);
        doctor.setTel(tel);
        doctor.setPass(pass);
        doctor.setPosition(position);

        //  Boolean checkName=name.matches("[^a-zA-Zа-яА-я]");
        //  Boolean checkSurName=surname.matches("[^a-zA-Zа-яА-я]");
        //  Boolean checkEmail=email.matches("\\D");
        //   Boolean checktel=tel.matches("\\D");
        //  Boolean checkPass=email.matches();  //   ^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$
        // https://web.izjum.com/regexp-email-url-phone
        // чекнуть правильность всех граф
        // если ок соединяемся с бд и чекаем email и тел по базе
        // запрос в бд на наличие email и телефона
        // если все ок
        // добавляем customer
        doctor = daOwork.addNewDoc(doctor);
        return doctor;
    }

    public Customer getCustomerById (int id) throws SQLException {
        Customer customer=daOwork.getCustomerById(id);
        return customer;
    }
    public Customer setCustomer(Customer customer) throws SQLException {
        Customer customer1=daOwork.setCustomer(customer);
        return customer1;
    }
    public Doctor getDocById (long id) throws SQLException {
        Doctor doctor=daOwork.getDocById(id);
        return doctor;
    }
    public Doctor getDocByLogin(String email) throws SQLException {
        Doctor doctor=daOwork.getDocByEmail(email);
        return doctor;
    }

    public Doctor setDoc(Doctor doc) throws SQLException {
        Doctor doctor=daOwork.setDoc(doc);
        return doctor;
    }
    public ArrayList<Doctor> getDocByName(String name) throws SQLException{
        ArrayList<Doctor> docList = new ArrayList<>();
        docList=daOwork.getDocByName(name);
        return  docList;
    }
    public ArrayList<Doctor> getDocBySurName(String surname) throws SQLException{
        ArrayList<Doctor> docList = new ArrayList<>();
        docList=daOwork.getDocByName(surname);
        return  docList;
    }
    public Pet addNewPet(Pet pet) throws SQLException {
       Pet pet2= daOwork.addNewPet(pet);
        return pet2;
    }
    public Pet setPet(Pet pet) throws SQLException {
        Pet rezult=daOwork.setPet(pet);
        return rezult;
    }

    // все петы без доктора
    public ArrayList<Pet> petwithoutDoc() throws SQLException {
        ArrayList<Pet> rezult=daOwork.getPetsWithoutDoc();
        return rezult;
    }

    public void setDocToPet(Doctor doc, long idpet) throws SQLException {
        Pet pet=daOwork.getPetbyid(idpet);
        daOwork.setDocToPet(doc,pet);
    }

}
