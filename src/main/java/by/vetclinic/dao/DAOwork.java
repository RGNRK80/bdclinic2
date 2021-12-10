package by.vetclinic.dao;

import by.vetclinic.entity.*;
import lombok.Data;

import java.sql.*;
import java.util.ArrayList;

@Data
public class DAOwork {
    private Connection connection;
    private String url;
    private String log;
    private String pass;

    public DAOwork(String url, String log, String pass) throws SQLException {
        this.url=url;
        this.log=log;
        this.pass=pass;
        //connection = DriverManager.getConnection(url,log,pass);


    }

   // @Override
    public Doctor addNewDoc(Doctor doc) throws SQLException {
       connection = DriverManager.getConnection(url,log,pass);

        String insert = "INSERT INTO doc (`name`, `surname`, `tel`, `email_log`, `pass`,`position`) VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1,doc.getName());
        preparedStatement.setString(2,doc.getSurname());
        preparedStatement.setString(3,doc.getTel());
        preparedStatement.setString(4,doc.getEmail());
        preparedStatement.setString(5,doc.getPass());
        preparedStatement.setString(6,doc.getPosition());
        preparedStatement.execute();

        Doctor doc2=new Doctor();
        String insert1 = "SELECT * FROM doc where tel=? ";
        PreparedStatement preparedStatement1=connection.prepareStatement(insert1);
        preparedStatement1.setString(1,doc.getTel());
        ResultSet result = preparedStatement1.executeQuery();

        while (result.next()) {
            doc2.setId(result.getLong(1));
        }
        doc2= getDocById(doc2.getId());

        connection.close();
        return doc2;
    }

//  @Override
    public Doctor setDoc(Doctor doc) throws SQLException {
        connection = DriverManager.getConnection(url,log,pass);
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
        connection.close();
        return doc;
    }
/*
    @Override  // не нужно, меняем set ом на уволен
    public Doctor delDoc(Doctor doc) {
        return null;
    }
*/
  //  @Override
    public Doctor getDocById(long id) throws SQLException {
        connection = DriverManager.getConnection(url,log,pass);
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
        connection.close();
        return doctor;

    }





    public Doctor getDocByEmail(String email) throws SQLException {
        connection = DriverManager.getConnection(url,log,pass);
        Doctor doctor=new Doctor();

        String insert = "SELECT * FROM doc where email_log=?";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1, email);
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


        }
        connection.close();
        return doctor;

    }










   // @Override
    public ArrayList<Doctor> getDocByName(String name) throws SQLException{
        connection = DriverManager.getConnection(url,log,pass);
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
        connection.close();
        return docList;
    }

  // @Override
    public ArrayList<Doctor> getDocBySurName(String surname) throws SQLException {
        connection = DriverManager.getConnection(url,log,pass);
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
        connection.close();
        return docList;
    }






    public void setDocToPet(Doctor doc, Pet pet) throws SQLException {
        connection = DriverManager.getConnection(url,log,pass);
        String insert = "INSERT INTO doc_has_pet (`doc_idDoc`,`pet_idPet`) VALUES('?','?')";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1, String.valueOf(doc.getId()));
        preparedStatement.setString(2, String.valueOf(pet.getId()));
        preparedStatement.execute();
        connection.close();
    }

    public void setCustomerToPet(Customer customer, Pet pet) throws SQLException {
        connection = DriverManager.getConnection(url,log,pass);
        String insert = "INSERT INTO Pet_has_customer (`pet_idPet`,`customer_info_idCustomer`) VALUES('?','?')";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(2, String.valueOf(customer.getId()));
        preparedStatement.setString(1, String.valueOf(pet.getId()));
        preparedStatement.execute();
        connection.close();
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

        connection.close();
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
        connection.close();
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
    public Customer getCustomerById(long id) throws SQLException {
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
        connection.close();
        return customer;
    }

    public Customer getCustomerByMail(String emale) throws SQLException {
        Customer customer=new Customer();
        String insert = "SELECT * FROM customer where email_log=?";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1, emale);
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            customer.setId(result.getLong(1));
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
        connection.close();
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
        preparedStatement.execute();

        Pet pet2 = new Pet();
        String insert1 = "SELECT * FROM pet where name=? and type=? and sex=? and age=? and date_inn=? ";
        PreparedStatement preparedStatement1=connection.prepareStatement(insert1);
        preparedStatement1.setString(1,pet.getName());
        preparedStatement1.setString(2,pet.getType());
        preparedStatement1.setString(3,pet.getSex());
        preparedStatement1.setInt(4,pet.getAge());
        preparedStatement1.setString(5,pet.getDateInn());
        ResultSet result = preparedStatement1.executeQuery();

        while (result.next()) {
            pet2.setId(result.getLong(1));
            pet2.setName(result.getString(2));
            pet2.setType(result.getString(3));
            pet2.setSex(result.getString(4));
            pet2.setAge(result.getInt(5));
            pet2.setDateInn(result.getString(6));
            pet2.setCondition(result.getString(7));
            pet2.setHistory(result.getString(8));
            pet2.setDrugs(result.getString(9));
            pet2.setTotalHistory(result.getString(10));

        }
        connection.close();
        return pet2;
    }

  //  @Override
    public Pet setPet(Pet pet) throws SQLException {

        String insert = "UPDATE pet Set name=?, type=?, sex=?, age=?, date_inn=?,condition=?,history=?, drugs=?, total_history=? WHERE idPet=?";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1,pet.getName());
        preparedStatement.setString(2,pet.getType());
        preparedStatement.setString(3,pet.getSex());
        preparedStatement.setInt(4,pet.getAge());
        preparedStatement.setString(5,pet.getDateInn());
        preparedStatement.setString(6,pet.getCondition());
        preparedStatement.setString(7,pet.getHistory());
        preparedStatement.setString(8,pet.getDrugs());
        preparedStatement.setString(9,pet.getTotalHistory());
        preparedStatement.setLong(10,pet.getId());
        preparedStatement.executeUpdate();

        Pet rezultPet=getPetbyid(pet.getId());
        connection.close();
        return rezultPet;
    }
    /*
        @Override
        public ArrayList<Pet> getPetbyName(String name) {
            return null;
        }

        @Override
        public ArrayList<Pet> getPetbyType(String type) {
            return null;
        }
    */
//    @Override
    public Pet getPetbyid(long id) throws SQLException {
        Pet pet=new Pet();
        String insert = "SELECT * FROM pet where idPet=?";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setString(1, String.valueOf(id));
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            pet.setId(result.getLong(1));
            pet.setName(result.getString(2));
            pet.setType(result.getString(3));
            pet.setSex(result.getString(4));
            pet.setAge(result.getInt(5));
            pet.setDateInn(result.getString(6));
            pet.setCondition(result.getString(7));
            pet.setHistory(result.getString(8));
            pet.setDrugs(result.getString(9));
            pet.setTotalHistory(result.getString(10));

        }
        connection.close();
        return pet;
    }

}