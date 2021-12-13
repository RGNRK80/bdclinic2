package by.vet.entity;

import lombok.Data;

@Data
public class User {
    private  long id;
    private  String tel;
    private  String mail;
    private  Userinfo userinfo;
}
