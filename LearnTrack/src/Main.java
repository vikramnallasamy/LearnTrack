import entity.*;
import service.CourseService;
import service.EnrollmentService;
import service.StudentService;
import utility.EntityNotFoundException;
import utility.InvalidInputException;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static StudentService studentService = new StudentService();
    static CourseService courseService = new CourseService();
    static EnrollmentService enrollmentService = new EnrollmentService();
    static Scanner sc = new Scanner(System.in);
    static int option = 0;
    static InputTypeMain inputType;

    public static void displayMainMenu() {
        System.out.println("LEARNING MANAGEMENT SYSTEM");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrollment Management");
        System.out.println("4. Exit");
    }

    public static String readString() throws InvalidInputException {
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("")) {
            throw new InvalidInputException("Invalid Input.. Empty");
        }
        return input;
    }

    public static int readNumber() throws InvalidInputException {
        int number;
        try {
            number = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            throw new InvalidInputException("Invalid Input... Enter a Number");
        }
        return number;
    }

    public static Student getStudentDetails() throws InvalidInputException {
        String isActive, firstName, lastName, batch, email;
        boolean isActiveBool = false;
            System.out.println("Enter first name...");
            firstName = readString();
            System.out.println("Enter last name...");
            lastName = readString();
            System.out.println("Enter email...");
            email = readString();
            System.out.println("Enter batch...");
            batch = readString();
            System.out.println("Enter isActive(Y/N)...");
            isActive = readString();
            isActiveBool = isActive.equalsIgnoreCase("Y");
            return new Student(firstName, lastName, email, batch, isActiveBool);
    }

    public static Course getCourseDetails() throws InvalidInputException {
        String name, description;
        int durationInWeeks;
        String status;
            System.out.println("Enter course name...");
            name = readString();
            System.out.println("Enter description...");
            description = readString();
            System.out.println("Enter duration in weeks...");
            durationInWeeks = readNumber();
            System.out.println("Is active (Y/N) ");
            status = readString();
            boolean statusIsActive = status.equalsIgnoreCase("Y");

            return new Course(name, description, durationInWeeks, statusIsActive);
    }

    private void displayStudent(Student st) {
        System.out.println("\nID: " + st.getId());
        System.out.println("First Name: " + st.getFirstName());
        System.out.println("LastName: " + st.getLastName());
        System.out.println("Email: " + st.getEmail());
        System.out.println("Batch: " + st.getBatch());
        System.out.println("IsActive: " + st.isActive());
    }

    public static void studentMangementMenu() {

        int option = 0;
        do {
            System.out.println("\n\nStudent Management\n");

            System.out.println("1. Add New Student.");
            System.out.println("2. View all students.");
            System.out.println("3. Search student by ID.");
            System.out.println("4. Deactivate a student. ");
            System.out.println("5. Back to main menu. ");
            try {
                option = readNumber();
                switch (option) {
                    case 1:
                        studentService.addNewStudent(getStudentDetails());
                        break;
                    case 2:
                        studentService.listAllStudents();
                        break;
                    case 3:
                        System.out.println("Enter Student Id..");
                        int id = readNumber();
                        Student student = studentService.searchStudentById(id);
                        studentService.displayStudent(student);
                        break;
                    case 4:
                        id = readNumber();
                        studentService.deactivateStudent(id);
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid Option");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (option != 5);
    }

    public static void courseManagementMenu() {

        int option = 0;
        do {
            System.out.println("\n\nCourse Management\n");

            System.out.println("1. Add New Course.");
            System.out.println("2. View all courses.");
            System.out.println("3. Activate/Deactivate a course. ");
            System.out.println("4. Back to main menu. ");
            try {
                option = readNumber();
                switch (option) {
                    case 1:
                        courseService.addNewCourse(getCourseDetails());
                        break;
                    case 2:
                        courseService.listAllCourses();
                        break;

                    case 3:
                        System.out.println(" Enter course ID");
                        int id = readNumber();
                        System.out.println("Is Active(Y/N)?");
                        String status = readString();
                        boolean isActive = status.equalsIgnoreCase("Y");
                        courseService.updateCourseStatus(id, isActive);

                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("No Such Option");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (option != 4);
    }

    public static void displayEnrollments(List<Enrollment> enrollments) {
        for (int i = 0; i < enrollments.size(); i++) {
            System.out.println("ID: " + enrollments.get(i).getId());
            System.out.println("Student ID: " + enrollments.get(i).getStudentId());
            System.out.println("Course ID: " + enrollments.get(i).getCourseId());
            System.out.println("Enrollment Date: " + enrollments.get(i).getEnrollmentDate());
            System.out.println("Status: " + enrollments.get(i).getStatus());
        }
    }


    public static void enrollmentManagementMenu() {

        int option = 0;
        do {
            System.out.println("\n\nEnrollment Management\n");

            System.out.println("1. Enroll Student.");
            System.out.println("2. View Enrollment for a Student.");
            System.out.println("3. Mark enrollment as completed/cancelled. ");
            System.out.println("4. Back to main menu. ");
            try {
                option = readNumber();

                switch (option) {
                    case 1:
                        System.out.println("Enter Course Id...");
                        int courseId = readNumber();
                        System.out.println("Enter Student Id...");
                        int studentId = readNumber();
                        LocalDate today = LocalDate.now();
                        System.out.println("Enter status... 1. ACTIVE, 2. COMPLETED, 3.CANCELLED ");
                        int status = readNumber();
                        EnrollmentStatus enrollmentStatus = EnrollmentStatus.values()[status - 1];
                        enrollmentService.enrollStudentInCourse(studentId, courseId, today, enrollmentStatus);

                        break;
                    case 2:
                        System.out.println("Enter Student Id...");
                        studentId = readNumber();
                        try {
                            displayEnrollments(enrollmentService.getEnrollmentsForStudent(studentId));
                        } catch (EntityNotFoundException e) {
                            System.out.println(e.getMessage());
                        }

                        break;

                    case 3:
                        System.out.println(" Enter Enrollment ID");
                        int id = readNumber();
                        System.out.println("Enter status... 1. ACTIVE, 2. COMPLETED, 3.CANCELLED ");
                        status = readNumber();
                        enrollmentStatus = EnrollmentStatus.values()[status - 1];
                        enrollmentService.updateEnrollmentStatus(id, enrollmentStatus);

                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Invalid Option");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (option != 4);
    }


    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        while (option != 4) {
            displayMainMenu();
            try {
                option = readNumber();
                switch (option) {
                    case 1:
                        studentMangementMenu();
                        break;
                    case 2:
                        courseManagementMenu();
                        break;
                    case 3:
                        enrollmentManagementMenu();
                        break;
                    case 4:
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

}