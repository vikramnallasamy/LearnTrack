package service;

import entity.Course;
import utility.EntityNotFoundException;

import java.util.ArrayList;

public class CourseService implements CourseServiceInterface{

    static ArrayList<Course> courses = new ArrayList<>();
    /**
     *
     */
    @Override
    public void addNewCourse(Course course) {
            courses.add(course);
    }
    public void displayCourse(Course st) {
        System.out.println("\n\nID: "+ st.getId());
        System.out.println("Name: "+ st.getName());
        System.out.println("Description: "+ st.getDescription());
        System.out.println("DurationInWeeks: "+ st.getDurationInWeeks());
        System.out.println("Status: "+ st.getCourseStatus());
    }
    @Override
    public void listAllCourses() throws EntityNotFoundException {
            if(courses.isEmpty()) {
                throw new EntityNotFoundException("Course list is empty.. add some courses");
            }
        for (Course course : courses) {
            displayCourse(course);
        }
    }


    /**
     * @param id
     * @param isActive
     */
    @Override
    public void updateCourseStatus(int id, boolean isActive) throws EntityNotFoundException {
        boolean found = false;
        for (Course course : courses) {
            if (course.getId() == id) {
                course.setCourseStatus(isActive);
                found = true;
                break;
            }
        }
        if(!found) {
            throw new EntityNotFoundException("No Such Course");
        }
    }



}
