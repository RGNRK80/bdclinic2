package by.vet.entity;

import lombok.Data;
import org.springframework.stereotype.Component;


@Data
public class User {
    private  long id;
    private  String tel;
    private  String mail;
  //  private  Userinfo userinfo;
}
