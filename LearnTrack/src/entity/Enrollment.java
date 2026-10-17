package entity;

import utility.IdGenerator;

import java.time.LocalDate;

public class Enrollment {
    int id;
    int studentId;
    int courseId;
    LocalDate enrollmentDate;
    EnrollmentStatus status;

    public Enrollment(int studentId, int courseId, LocalDate enrollmentDate, EnrollmentStatus status) {
        this.id = IdGenerator.getNextEnrollmentId();
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }
}
