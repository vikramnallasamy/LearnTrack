package entity;

import utility.IdGenerator;

public class Course {

    private final int id;
    private String name;
    private boolean courseStatus;
    private String description;
    int durationInWeeks;

    public Course(String name, String description, int durationInWeeks, boolean courseStatus) {
        this.id = IdGenerator.getNextCourseId();
        this.name = name;
        this.courseStatus = courseStatus;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public boolean getCourseStatus() {
        return courseStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseStatus(boolean courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }
}
