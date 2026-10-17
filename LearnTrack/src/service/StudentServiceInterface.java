package service;

import entity.Student;
import utility.EntityNotFoundException;


public interface StudentServiceInterface {

    void addNewStudent(Student student);

    void listAllStudents() throws EntityNotFoundException;

    Student searchStudentById(int id) throws EntityNotFoundException;

    void deactivateStudent(int id) throws EntityNotFoundException;
}
