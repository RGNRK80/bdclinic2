package by.vetclinic.entity;

import lombok.Data;

@Data
public class Customer {

    private long id;
    private String name;
    private String surname;
    private String tel;
    private String email;
    private String pass;
    private Role role;
    private Status status;
    private double checkToPay;
    private double totalPayment;
    private int discount;

    public Customer() {

    }
}
