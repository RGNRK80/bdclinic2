package by.vetclinic.service;

import by.vetclinic.dao.DAOwork;
import by.vetclinic.entity.Customer;

import java.sql.SQLException;

public class Service {
    DAOwork daOwork=new DAOwork();

        public boolean connect(String url, String log, String pass) throws SQLException {
        return daOwork.connect(url, log, pass);

    }

    public void addNewCustomer(String name, String surname, String email, String tel, String pass) {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setSurname(surname);
            customer.setEmail(email);
            customer.setTel(tel);
            customer.setPass(pass);
            daOwork.addNewCustomer(customer);

            // чекнуть правильность всех граф
            // если ок соединяемся с бд и чекаем email и тел по базе


            // запрос в бд на наличие email и телефона

            // если все ок
            // добавляем customer







    }


}
