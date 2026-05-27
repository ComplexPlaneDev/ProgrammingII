package App.report;

import App.model.Course;
import App.model.Enrollment;
import App.model.Student;
import App.service.GradeCalculator;
import App.service.GPACalculator;

public class TranscriptGenerator {
    private GradeCalculator gradeCalculator;
    private GPACalculator gpaCalculator;

    public TranscriptGenerator() {
        this.gradeCalculator = new GradeCalculator();
        this.gpaCalculator = new GPACalculator();
    }

    public void generateTranscript(Student student) {
        printHeader(student);
        printCourseDetails(student);
        printSummary(student);
    }

    private void printHeader(Student student) {
        System.out.println("========================================");
        System.out.println("         ACADEMIC TRANSCRIPT");
        System.out.println("========================================");
        System.out.println("Student ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("----------------------------------------");
    }

    private void printCourseDetails(Student student) {
        for (Enrollment enrollment : student.getEnrollments()) {
            printEnrollmentDetails(enrollment);
        }
    }

    private void printEnrollmentDetails(Enrollment enrollment) {
        Course course = enrollment.getCourse();
        double numericGrade = gradeCalculator.calculateNumericGrade(enrollment);
        String letterGrade = gradeCalculator.calculateLetterGrade(enrollment);
        double gradePoints = gradeCalculator.calculateGradePoints(enrollment);

        System.out.println("Course: " + course.getCode() + " - " + course.getName());
        System.out.println("  Numeric Grade: " + String.format("%.2f", numericGrade) + "%");
        System.out.println("  Letter Grade: " + letterGrade);
        System.out.println("  Grade Points: " + gradePoints);
        System.out.println();
    }

    private void printSummary(Student student) {
        double gpa = gpaCalculator.calculateGPA(student);
        System.out.println("----------------------------------------");
        System.out.println("Cumulative GPA: " + String.format("%.2f", gpa));
        System.out.println("========================================");
    }
}
