package by.vet.dto;

import by.vet.entity.Role;
import by.vet.entity.Status;
import lombok.Data;

@Data
public class PetDataDTO {


    private long idPet;
    private String name;
    private String type;
    private String sex;

    private long idDoc;
    private long idCustomer;

    private String condition;
    private Status status;
}
