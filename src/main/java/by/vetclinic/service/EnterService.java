package by.vetclinic.service;

import by.vetclinic.dao.DAOwork;
import by.vetclinic.entity.Customer;
import by.vetclinic.entity.Doctor;
import by.vetclinic.entity.Role;
import lombok.Data;

import java.sql.Connection;
import java.sql.SQLException;

@Data
public class EnterService {
    private String url;
    private String log;
    private String pass;
    private DAOwork daOwork;
    private Connection connection;

    public EnterService (String url,String log,String pass) throws SQLException {
        this.url =url;
        this.log=log;
        this.pass=pass;
        daOwork=new DAOwork(url, log, pass);
        System.out.println("s " +this.url);
        System.out.println("s "+this.log);
        System.out.println("s "+this.pass);
    }

    // возвращает null если пользователь или доктор по этой почте существует или  возвращает customer если  логин свободен;
    public Customer addNewCustomer(String name, String surname, String email, String tel, String pass) throws SQLException {
        Customer check = daOwork.getCustomerByMail(email);
        if (check==null) {daOwork.getDocByEmail(email);}
        if (check==null) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setSurname(surname);
        customer.setEmail(email);
        customer.setTel(tel);
        customer.setPass(pass);
        customer=daOwork.addNewCustomer(customer);
        return customer; }
        else return null;
    }



    public Role getRole (String login, String pass) throws SQLException {
        Role role = null;
        // чекнуть логин/пароль в customer
        // чекнуть логин/пароль в doc
        Doctor doc = daOwork.getDocByEmail(login);
        if (doc.getRole()!=null) {role=doc.getRole();}
        Customer customer = daOwork.getCustomerByMail(login);
        if (customer.getRole()!=null) {role=customer.getRole();}
        return role;
    }

}
