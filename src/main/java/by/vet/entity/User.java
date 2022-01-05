package by.vet.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
//@Data
public class User {
    private  long id;
    private  String login_tel;
    private  String mail;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getLogin_tel() {
        return login_tel;
    }
    public void setLogin_tel(String login_tel) {
        this.login_tel = login_tel;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login_tel='" + login_tel + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
