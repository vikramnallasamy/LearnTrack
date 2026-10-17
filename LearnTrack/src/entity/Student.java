package entity;

import utility.IdGenerator;

public class Student extends Person{

    private String batch;
    private boolean active;

    public Student(String firstName, String lastName, String email, String batch, boolean active) {
        super(firstName,lastName,email);
        this.id = IdGenerator.getNextStudentId();
        this.batch = batch;
        this.active = active;
    }

    //Student without email
    public Student(String firstName, String lastName, String batch, boolean active) {
        super(firstName,lastName);
        this.id = IdGenerator.getNextStudentId();
        this.batch = batch;
        this.active = active;
    }


    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
