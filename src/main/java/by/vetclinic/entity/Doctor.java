package by.vetclinic.entity;

public class Doctor extends User{
    private String position;

    public Doctor() {
        super();
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
