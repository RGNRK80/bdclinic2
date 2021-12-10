package by.vetclinic.entity;

import by.vetclinic.service.Service;
import lombok.Data;

@Data
public class Admin {
    private long id;
    private String name;
    private String surname;
    private String tel;
    private String email;
    private String pass;
    private Role role;
    private Status status;
}
