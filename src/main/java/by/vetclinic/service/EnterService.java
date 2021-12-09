package by.vetclinic.service;

import by.vetclinic.dao.DAOwork;
import by.vetclinic.entity.Customer;
import by.vetclinic.entity.Role;
import lombok.Data;

import java.sql.Connection;
import java.sql.SQLException;

@Data
public class EnterService {
    String url;
    String log;
    String pass;
    DAOwork daOwork;
    Connection connection;

    public EnterService (String url,String log,String pass) throws SQLException {
        this.url =url;
        this.log=log;
        this.pass=pass;
        daOwork=new DAOwork(url, log, pass);
        System.out.println("s " +this.url);
        System.out.println("s "+this.log);
        System.out.println("s "+this.pass);
    }

    // возвращает null если пользователь существует или customer если  логин свободен;
    public Customer addNewCustomer(String name, String surname, String email, String tel, String pass) throws SQLException {
        Customer check = daOwork.getCustomerByMail(email);
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




    public Role getRole (String login, String pass) {
        Role role = null;
        return role;
    }

}
