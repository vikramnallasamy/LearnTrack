package service;

import entity.Student;
import utility.EntityNotFoundException;

import java.util.ArrayList;

public class StudentService implements StudentServiceInterface{

    static ArrayList<Student> students = new ArrayList<>();
    /**
     *
     */
    @Override
    public void addNewStudent(Student student) {
       students.add(student);
    }
    public void displayStudent(Student st) {
        System.out.println("\n\nID: "+ st.getId());
        System.out.println("First Name: "+ st.getFirstName());
        System.out.println("LastName: "+ st.getLastName());
        System.out.println("Email: "+ st.getEmail());
        System.out.println("Batch: "+ st.getBatch());
        System.out.println("IsActive: "+ st.isActive());
    }

    @Override
    public void listAllStudents() throws EntityNotFoundException{
            if(students.isEmpty()) {
                throw new EntityNotFoundException("Student list is empty.. add some students");
            }
        for (Student student : students) {
            displayStudent(student);
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Student searchStudentById(int id) throws EntityNotFoundException {

        for(Student st : students) {
            if(st.getId() == id) {
                return st;
            }
        }
        throw new EntityNotFoundException("Entity Not Found");
    }

    /**
     * @param id
     */
    @Override
    public void deactivateStudent(int id) throws EntityNotFoundException {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setActive(false);
                return;
            }
        }
        throw new EntityNotFoundException("Entity Not Found");
    }



}
