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

    private final String ADD_NEW_DOC = "INSERT INTO doc (`name`, `surname`, `tel`, `email_log`, `pass`,`position`)" +
            " VALUES(?,?,?,?,?,?)";
    private final String SET_DOC = "UPDATE doc Set name=?, surname=?, tel=?, email_log=?, pass=?, position=? " +
            "WHERE idDoc=?";
    private final String GET_DOC_BY_ID = "SELECT * FROM doc where idDoc=?";
    private final String GET_DOC_BY_EMAIL = "SELECT * FROM doc where email_log=?";
    private final String GET_DOC_BY_NAME = "SELECT * FROM doc where name=?";
    private final String GET_DOC_BY_SUNAME = "SELECT * FROM doc where surname=?";
    private final String SET_DOC_TO_PET = "INSERT INTO doc_has_pet (`doc_idDoc`,`pet_idPet`) VALUES('?','?')";
    private final String SET_CUSTOMER_TO_PET = "INSERT INTO Pet_has_customer (`pet_idPet`,`customer_info_idCustomer`) VALUES('?','?')";
    private final String ADD_NEW_CUSTOMER = "INSERT INTO customer (`name`, `surname`, `tel`, `email_log`, `pass`) VALUES(?,?,?,?,?)";
    private final String SET_CUSTOMER = "UPDATE customer Set name=?, surname=?, tel=?, email_log=?, pass=? WHERE idCustomer=?";
    private final String GET_CUSTOMER_BY_ID = "SELECT * FROM customer where idCustomer=?";
    private final String GET_CUSTOMER_BY_MAIL = "SELECT * FROM customer where email_log=?";
    private final String ADD_NEW_PET = "INSERT INTO pet (`name`, `type`, `sex`, `age`, `date_inn`) VALUES(?,?,?,?,?)";
    private final String ADD_ID_TO_PET = "SELECT * FROM pet where name=? and type=? and sex=? and age=? and date_inn=?";
    private final String SET_PET = "UPDATE pet Set name=?, type=?, sex=?, age=?, date_inn=?,condition=?,history=?, drugs=?, total_history=? WHERE idPet=?";
    private final String GET_PET_BY_ID = "SELECT * FROM pet where idPet=?";
    private final String GET_PET_WITHOUT_DOC = "SELECT * from Pet join doc_has_pet on idPet=pet_idPet WHERE doc_has_pet.doc_idDoc=null";


    public DAOwork(String url, String log, String pass) throws SQLException {
        this.url = url;
        this.log = log;
        this.pass = pass;
        //connection = DriverManager.getConnection(url,log,pass);
    }

    public Connection connect() throws SQLException {
        Connection connectionEx = DriverManager.getConnection(url, log, pass);
        return connectionEx;
    }

    // @Override
    public Doctor addNewDoc(Doctor doc) throws SQLException {
        connection = connect();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_DOC);
        preparedStatement.setString(1, doc.getName());
        preparedStatement.setString(2, doc.getSurname());
        preparedStatement.setString(3, doc.getTel());
        preparedStatement.setString(4, doc.getEmail());
        preparedStatement.setString(5, doc.getPass());
        preparedStatement.setString(6, doc.getPosition());
        preparedStatement.execute();

        Doctor doc2 = new Doctor();
        String insert1 = "SELECT * FROM doc where tel=? ";
        PreparedStatement preparedStatement1 = connection.prepareStatement(insert1);
        preparedStatement1.setString(1, doc.getTel());
        ResultSet result = preparedStatement1.executeQuery();

        while (result.next()) {
            doc2.setId(result.getLong(1));
        }
        doc2 = getDocById(doc2.getId());

        connection.close();
        return doc2;
    }

    //  @Override
    public Doctor setDoc(Doctor doc) throws SQLException {
        connection = connect();
        PreparedStatement preparedStatement = connection.prepareStatement(SET_DOC);
        preparedStatement.setString(1, doc.getName());
        preparedStatement.setString(2, doc.getSurname());
        preparedStatement.setString(3, doc.getTel());
        preparedStatement.setString(4, doc.getEmail());
        preparedStatement.setString(5, doc.getPass());
        preparedStatement.setString(6, doc.getPosition());
        preparedStatement.setLong(7, doc.getId());
        preparedStatement.executeUpdate();
        connection.close();
        return doc;
    }

    //  @Override
    public Doctor getDocById(long id) throws SQLException {
        connection = connect();
        Doctor doctor = new Doctor();
        doctor.setId(id);
        PreparedStatement preparedStatement = connection.prepareStatement(GET_DOC_BY_ID);
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
        connection = connect();
        Doctor doctor = new Doctor();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_DOC_BY_EMAIL);
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
    public ArrayList<Doctor> getDocByName(String name) throws SQLException {
        connection = connect();
        ArrayList<Doctor> docList = new ArrayList<>();
        Doctor doctor = new Doctor();
       // String insert = "SELECT * FROM doc where name=?";
        PreparedStatement preparedStatement = connection.prepareStatement(GET_DOC_BY_NAME);
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
        connection = connect();
        ArrayList<Doctor> docList = new ArrayList<>();
        Doctor doctor = new Doctor();
        //String insert = "SELECT * FROM doc where surname=?";
        PreparedStatement preparedStatement = connection.prepareStatement(GET_DOC_BY_SUNAME);
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
        connection = connect();
        //String insert = "INSERT INTO doc_has_pet (`doc_idDoc`,`pet_idPet`) VALUES('?','?')";
        PreparedStatement preparedStatement = connection.prepareStatement(SET_DOC_TO_PET);
        preparedStatement.setString(1, String.valueOf(doc.getId()));
        preparedStatement.setString(2, String.valueOf(pet.getId()));
        preparedStatement.execute();
        connection.close();
    }

    public void setCustomerToPet(Customer customer, Pet pet) throws SQLException {
        connection = connect();
        //String insert = "INSERT INTO Pet_has_customer (`pet_idPet`,`customer_info_idCustomer`) VALUES('?','?')";
        PreparedStatement preparedStatement = connection.prepareStatement(SET_CUSTOMER_TO_PET);
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
        connection = connect();
       // String insert = "INSERT INTO customer (`name`, `surname`, `tel`, `email_log`, `pass`) VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_CUSTOMER);
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2, customer.getSurname());
        preparedStatement.setString(3, customer.getTel());
        preparedStatement.setString(4, customer.getEmail());
        preparedStatement.setString(5, customer.getPass());
        preparedStatement.execute();
        connection.close();
        return customer;
    }

    // @Override
    public Customer setCustomer(Customer customer) throws SQLException {
        connection = connect();
       // String insert = "UPDATE customer Set name=?, surname=?, tel=?, email_log=?, pass=? WHERE idCustomer=?";
        PreparedStatement preparedStatement = connection.prepareStatement(SET_CUSTOMER);
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2, customer.getSurname());
        preparedStatement.setString(3, customer.getTel());
        preparedStatement.setString(4, customer.getEmail());
        preparedStatement.setString(5, customer.getPass());
        preparedStatement.setLong(6, customer.getId());
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
        connection = connect();
        Customer customer = new Customer();
        customer.setId(id);
        //String insert = "SELECT * FROM customer where idCustomer=?";
        PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMER_BY_ID);
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
        Customer customer = new Customer();
        // String insert = "SELECT * FROM customer where email_log=?";
        connection = connect();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMER_BY_MAIL);
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
        connection = connect();
        //String insert = "INSERT INTO pet (`name`, `type`, `sex`, `age`, `date_inn`) VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_PET);
        preparedStatement.setString(1, pet.getName());
        preparedStatement.setString(3, pet.getSex());
        preparedStatement.setInt(4, pet.getAge());
        preparedStatement.setString(5, pet.getDateInn());
        preparedStatement.setString(2, pet.getType());
        preparedStatement.execute();

        Pet pet2 = new Pet();
        //String insert1 = "SELECT * FROM pet where name=? and type=? and sex=? and age=? and date_inn=? ";
        PreparedStatement preparedStatement1 = connection.prepareStatement(ADD_ID_TO_PET);
        preparedStatement1.setString(1, pet.getName());
        preparedStatement1.setString(2, pet.getType());
        preparedStatement1.setString(3, pet.getSex());
        preparedStatement1.setInt(4, pet.getAge());
        preparedStatement1.setString(5, pet.getDateInn());
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
        connection = connect();
        //String insert = "UPDATE pet Set name=?, type=?, sex=?, age=?, date_inn=?,condition=?,history=?, drugs=?, total_history=? WHERE idPet=?";
        PreparedStatement preparedStatement = connection.prepareStatement(SET_PET);
        preparedStatement.setString(1, pet.getName());
        preparedStatement.setString(2, pet.getType());
        preparedStatement.setString(3, pet.getSex());
        preparedStatement.setInt(4, pet.getAge());
        preparedStatement.setString(5, pet.getDateInn());
        preparedStatement.setString(6, pet.getCondition());
        preparedStatement.setString(7, pet.getHistory());
        preparedStatement.setString(8, pet.getDrugs());
        preparedStatement.setString(9, pet.getTotalHistory());
        preparedStatement.setLong(10, pet.getId());
        preparedStatement.executeUpdate();

        Pet rezultPet = getPetbyid(pet.getId());
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
        connection = connect();
        Pet pet = new Pet();
        //String insert = "SELECT * FROM pet where idPet=?";
        PreparedStatement preparedStatement = connection.prepareStatement(GET_PET_BY_ID);
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

    public ArrayList<Pet> getPetsWithoutDoc() throws SQLException {
        ArrayList<Pet> arrpet = new ArrayList<>();
        //String insert = "SELECT * from Pet join doc_has_pet on idPet=pet_idPet WHERE doc_has_pet.doc_idDoc=null;";
        connection = connect();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_PET_WITHOUT_DOC);
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            Pet pet = new Pet();
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
            arrpet.add(pet);
        }
        return arrpet;
    }

}