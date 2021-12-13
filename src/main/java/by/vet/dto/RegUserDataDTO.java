package by.vet.dto;

import by.vet.entity.Role;
import by.vet.entity.Status;
import lombok.Data;

@Data
public class RegUserDataDTO {
    private String login_tel;
    private String email;
    private String name;
    private String surname;
    private String pass;
    private Role   role= Role.CUSTOMER;
    private Status status;

}
