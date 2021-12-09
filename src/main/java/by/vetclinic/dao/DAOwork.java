package by.vetclinic.dao;

import by.vetclinic.entity.*;
import lombok.Data;

import java.sql.*;
import java.util.ArrayList;

@Data
public class DAOwork {
    private Connection connection;

    public DAOwork(String url, String log, String pass) throws SQLException {
        this.connection = DriverManager.getConnection(url,log,pass);
    }


   // @Override
    public Doctor addNewDoc(Doctor doc) throws SQLException {
        String insert = "INSERT INTO doc (`name`, `surname`, `tel`, `email_log`, `pass`,`position`) VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1,doc.getName());
        preparedStatement.setString(2,doc.getSurname());
        preparedStatement.setString(3,doc.getTel());
        preparedStatement.setString(4,doc.getEmail());
        preparedStatement.setString(5,doc.getPass());
        preparedStatement.setString(6,doc.getPosition());
        preparedStatement.execute();
        return doc;
    }

//  @Override
    public Doctor setDoc(Doctor doc) throws SQLException {
        String insert = "UPDATE doc Set name=?, surname=?, tel=?, email_log=?, pass=?, position=? WHERE idDoc=?";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1,doc.getName());
        preparedStatement.setString(2,doc.getSurname());
        preparedStatement.setString(3,doc.getTel());
        preparedStatement.setString(4,doc.getEmail());
        preparedStatement.setString(5,doc.getPass());
        preparedStatement.setString(6,doc.getPosition());
        preparedStatement.setLong(7,doc.getId());
        System.out.println("set:" + doc.toString());
        preparedStatement.executeUpdate();
        return doc;
    }
/*
    @Override  // не нужно, меняем set ом на уволен
    public Doctor delDoc(Doctor doc) {
        return null;
    }
*/
  //  @Override
    public Doctor getDocById(int id) throws SQLException {
        Doctor doctor=new Doctor();
        doctor.setId(id);
        String insert = "SELECT * FROM doc where idDoc=?";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1, String.valueOf(id));
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            doctor.setName(result.getString(2));
            doctor.setSurname(result.getString(3));
            doctor.setTel(result.getString(4));
            doctor.setEmail(result.getString(5));
            doctor.setPass(result.getString(6));
            doctor.setRole(Role.valueOf(result.getString(7)));
            doctor.setStatus(Status.valueOf(result.getString(8)));
            doctor.setPosition(result.getString(9));

        }
        return doctor;

    }

   // @Override
    public ArrayList<Doctor> getDocByName(String name) throws SQLException{
        ArrayList<Doctor> docList = new ArrayList<>();
        Doctor doctor=new Doctor();
        String insert = "SELECT * FROM doc where name=?";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1, name);
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            doctor.setId(result.getLong(1));
            doctor.setName(result.getString(2));
            doctor.setSurname(result.getString(3));
            doctor.setTel(result.getString(4));
            doctor.setEmail(result.getString(5));
            doctor.setPass(result.getString(6));
            doctor.setRole(Role.valueOf(result.getString(7)));
            doctor.setStatus(Status.valueOf(result.getString(8)));
            doctor.setPosition(result.getString(9));
            docList.add(doctor);
        }

        return docList;
    }

  // @Override
    public ArrayList<Doctor> getDocBySurName(String surname) throws SQLException {
      ArrayList<Doctor> docList = new ArrayList<>();
        Doctor doctor=new Doctor();
        String insert = "SELECT * FROM doc where surname=?";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1, surname);
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            doctor.setId(result.getLong(1));
            doctor.setName(result.getString(2));
            doctor.setSurname(result.getString(3));
            doctor.setTel(result.getString(4));
            doctor.setEmail(result.getString(5));
            doctor.setPass(result.getString(6));
            doctor.setRole(Role.valueOf(result.getString(7)));
            doctor.setStatus(Status.valueOf(result.getString(8)));
            doctor.setPosition(result.getString(9));
            docList.add(doctor);
        }

        return docList;
    }

    /*
       @Override
       public ArrayList<Doctor> getDocbyPet(Pet pet) {
           return null;
       }
   */
   //@Override
    public Customer addNewCustomer(Customer customer) throws SQLException {

        //System.out.println(" схема работает? "+ !connection.isClosed());
       //  System.out.println(" схема  "+ connection.getCatalog());

        String insert = "INSERT INTO customer (`name`, `surname`, `tel`, `email_log`, `pass`) VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1,customer.getName());
        preparedStatement.setString(2,customer.getSurname());
        preparedStatement.setString(3,customer.getTel());
        preparedStatement.setString(4,customer.getEmail());
        preparedStatement.setString(5,customer.getPass());
        preparedStatement.execute();


        return customer;
    }

   // @Override
    public Customer setCustomer(Customer customer) throws SQLException {
        String insert = "UPDATE customer Set name=?, surname=?, tel=?, email_log=?, pass=? WHERE idCustomer=?";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1,customer.getName());
        preparedStatement.setString(2,customer.getSurname());
        preparedStatement.setString(3,customer.getTel());
        preparedStatement.setString(4,customer.getEmail());
        preparedStatement.setString(5,customer.getPass());
        preparedStatement.setLong(6,customer.getId());
        System.out.println("set:" + customer.toString());
        preparedStatement.executeUpdate();
        return customer;
    }
/*
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
*/
    //@Override
    public Customer getCustomerById(int id) throws SQLException {
        Customer customer=new Customer();
        customer.setId(id);
        String insert = "SELECT * FROM customer where idCustomer=?";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1, String.valueOf(id));
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            customer.setName(result.getString(2));
            customer.setSurname(result.getString(3));
            customer.setTel(result.getString(4));
            customer.setEmail(result.getString(5));
            customer.setPass(result.getString(6));
            customer.setRole(Role.valueOf(result.getString(7)));
            customer.setStatus(Status.valueOf(result.getString(8)));
            customer.setCheckToPay(result.getDouble(9));
            customer.setTotalPayment(result.getDouble(10));
            customer.setDiscount(result.getInt(11));
        }
        return customer;
    }



  //  @Override
    public Pet addNewPet(Pet pet) throws SQLException {
        String insert = "INSERT INTO pet (`name`, `type`, `sex`, `age`, `date_inn`) VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1,pet.getName());
        preparedStatement.setString(3,pet.getSex());
        preparedStatement.setInt(4,pet.getAge());
        preparedStatement.setString(5,pet.getDateInn());
        preparedStatement.setString(2,pet.getType());
        return pet;
    }
/*
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