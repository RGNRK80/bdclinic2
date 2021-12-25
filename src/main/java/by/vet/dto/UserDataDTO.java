package by.vet.dto;

import by.vet.entity.Role;
import by.vet.entity.Status;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserDataDTO {
    private long id;
    private String login;
    Role role;
    Status status;

}
