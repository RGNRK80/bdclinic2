package by.vetclinic.entity;

public class Doctor {
    private long id;
    private String name;
    private String surname;
    private String tel;
    private String email;
    private String pass;
    private Role role;
    private Status status;
    private String position;

    public Doctor() {

    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
