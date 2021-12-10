package by.vetclinic.service;

import by.vetclinic.dao.DAOwork;
import by.vetclinic.entity.Doctor;
import by.vetclinic.entity.Pet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class DoctorService {
    private String url;
    private String log;
    private String pass;
    private DAOwork daOwork;
    private Connection connection;

    public DoctorService (String url,String log,String pass) throws SQLException {
        this.url =url;
        this.log=log;
        this.pass=pass;
        daOwork=new DAOwork(url, log, pass);
        System.out.println("s " +this.url);
        System.out.println("s "+this.log);
        System.out.println("s "+this.pass);
    }

    // все петы без доктора
    public ArrayList<Pet> petwithoutDoc() throws SQLException {
        ArrayList<Pet> rezult=daOwork.getPetsWithoutDoc();
        return rezult;
    }

    public Doctor getDocByLogin(String email) throws SQLException {
        Doctor doctor=daOwork.getDocByEmail(email);
        return doctor;
    }

    public void setDocToPet(Doctor doc, long idpet) throws SQLException {
        Pet pet=daOwork.getPetbyid(idpet);
        daOwork.setDocToPet(doc,pet);
    }
}
