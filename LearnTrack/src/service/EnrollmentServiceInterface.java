package service;

import entity.Enrollment;
import entity.EnrollmentStatus;
import utility.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface EnrollmentServiceInterface {

    void enrollStudentInCourse(int studentId, int courseId, LocalDate date, EnrollmentStatus enrollmentStatus) throws EntityNotFoundException;
    List<Enrollment> getEnrollmentsForStudent(int studentId) throws EntityNotFoundException;
    void updateEnrollmentStatus(int enrollmentId, EnrollmentStatus enrollmentStatus);
}
