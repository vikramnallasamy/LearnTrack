package service;

import entity.Course;
import entity.Enrollment;
import entity.EnrollmentStatus;
import entity.Student;
import utility.EntityNotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentService implements EnrollmentServiceInterface{
    List<Enrollment> enrollments = new ArrayList<>();
    /**
     * @param studentId
     * @param courseId
     */
    @Override
    public void enrollStudentInCourse(int studentId, int courseId,LocalDate date, EnrollmentStatus enrollmentStatus) throws EntityNotFoundException {
        boolean studentExist = false, courseExist = false;
        for(Student student : StudentService.students) {
            if(student.getId() == studentId) {
                studentExist = true;
            }
        }
        if(!studentExist) {
            throw new EntityNotFoundException("No Such Student with id: "+studentId);
        }

        for(Course course : CourseService.courses) {
            if(course.getId() == courseId) {
                courseExist = true;
            }
        }
        if(!courseExist) {
            throw new EntityNotFoundException("No Such Courrse with id: "+courseId);
        }
        if(CourseService.courses.isEmpty()) {
            throw new EntityNotFoundException("No Such Course with id: "+courseId);
        }
        enrollments.add(new Enrollment(studentId,courseId,date, enrollmentStatus));

    }

    /**
     * @param studentId
     * @return
     */
    @Override
    public List<Enrollment> getEnrollmentsForStudent(int studentId) throws EntityNotFoundException {
        List<Enrollment> studentEnrollments = new ArrayList<>();
        for(int i=0;i<enrollments.size();i++) {
            if(studentId == enrollments.get(i).getStudentId()) {
                studentEnrollments.add(enrollments.get(i));
            }
        }
        if(studentEnrollments.isEmpty()) {
            throw new EntityNotFoundException("No Such Student");
        }
        return studentEnrollments;
    }

    /**
     * @param enrollmentId
     * @param enrollmentStatus
     */
    @Override
    public void updateEnrollmentStatus(int enrollmentId, EnrollmentStatus enrollmentStatus) {
        for(int i=0;i<enrollments.size();i++) {
            if(enrollmentId == enrollments.get(i).getId()) {
                enrollments.get(i).setStatus(enrollmentStatus);
            }
        }
    }
}
