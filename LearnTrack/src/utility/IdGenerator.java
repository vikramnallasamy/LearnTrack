package utility;

public class IdGenerator {
    private static int studentId=0, courseId=0, enrollmentId = 0;

    public static int getNextStudentId() {
        return studentId++;
    }
    public static int getNextCourseId() {
        return courseId++;
    }
    public static int getNextEnrollmentId() {
        return enrollmentId++;
    }
}
