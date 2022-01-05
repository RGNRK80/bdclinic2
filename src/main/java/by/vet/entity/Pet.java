package by.vet.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Pet {
    private long idpet;
    private  String name;
    private  String type;
    private  String sex;

   // private  Pethistory pethistory;


}
