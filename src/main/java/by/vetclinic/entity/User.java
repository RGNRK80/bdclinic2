package by.vetclinic.entity;

import lombok.Data;

@Data
public abstract class User {
    private long id;
    private String name;
    private String surname;
    private String tel;
    private String email;
    private String pass;
    private Role role;
    private Status status;

    public User() {
    }
}
