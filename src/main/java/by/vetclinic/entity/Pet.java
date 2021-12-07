package by.vetclinic.entity;

import lombok.Data;

@Data
public class Pet {
    private long id;
    private String name;
    private String type;
    private String sex;
    private int age;
    private String dateInn;
    private String condition;
    private String history;
    private String drugs;
    private String totalHistory;

    public Pet() {
    }
}
