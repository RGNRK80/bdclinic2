package by.vet.dto;

import by.vet.entity.Role;
import by.vet.entity.Status;
import lombok.Data;

@Data
public class UserDataDTO {
    private long id;
    private String login;
    Role role;
    Status status;

}
