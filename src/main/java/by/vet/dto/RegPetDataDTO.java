package by.vet.dto;

import by.vet.entity.Role;
import by.vet.entity.Status;
import lombok.Data;

@Data
public class RegPetDataDTO {
    private String name;
    private String type;
    private String sex;

    private long idCustomer;
    private String dateInn;
    private String condition;
    private Status status;

}
