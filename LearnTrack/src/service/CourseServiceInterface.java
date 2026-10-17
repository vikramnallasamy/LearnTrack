package service;

import entity.Course;
import utility.EntityNotFoundException;

public interface CourseServiceInterface {

    void addNewCourse(Course course);

    void listAllCourses() throws EntityNotFoundException;

    void updateCourseStatus(int id, boolean isActive) throws EntityNotFoundException;
}
