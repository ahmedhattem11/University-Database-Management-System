package DTOS;

public class DTOReport {
    private int courseId;
    private String courseName;
    private int enrolledStudents;
    private double averageGPA;

    public DTOReport(int courseId, String courseName, int enrolledStudents, double averageGPA) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.enrolledStudents = enrolledStudents;
        this.averageGPA = averageGPA;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(int enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    // Getters and setters

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getAverageGPA() {
        return averageGPA;
    }

    public void setAverageGPA(double averageGPA) {
        this.averageGPA = averageGPA;
    }
}
