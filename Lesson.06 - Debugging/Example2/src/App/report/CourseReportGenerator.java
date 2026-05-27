package App.report;

import App.model.Course;
import App.model.Enrollment;
import App.model.Student;
import App.service.GradeCalculator;

import java.util.List;

public class CourseReportGenerator {
    private GradeCalculator gradeCalculator;

    public CourseReportGenerator() {
        this.gradeCalculator = new GradeCalculator();
    }

    public void generateCourseReport(Course course, List<Enrollment> enrollments) {
        printCourseHeader(course);
        printStudentGrades(enrollments);
        printCourseStatistics(enrollments);
    }

    private void printCourseHeader(Course course) {
        System.out.println("========================================");
        System.out.println("         COURSE GRADE REPORT");
        System.out.println("========================================");
        System.out.println("Course: " + course.getCode() + " - " + course.getName());
        System.out.println("----------------------------------------");
    }

    private void printStudentGrades(List<Enrollment> enrollments) {
        System.out.println("Student Grades:");
        for (Enrollment enrollment : enrollments) {
            printStudentGrade(enrollment);
        }
        System.out.println();
    }

    private void printStudentGrade(Enrollment enrollment) {
        Student student = enrollment.getStudent();
        double numericGrade = gradeCalculator.calculateNumericGrade(enrollment);
        String letterGrade = gradeCalculator.calculateLetterGrade(enrollment);

        System.out.println("  " + student.getName() + ": " +
                          String.format("%.2f", numericGrade) + "% (" + letterGrade + ")");
    }

    private void printCourseStatistics(List<Enrollment> enrollments) {
        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for (Enrollment enrollment : enrollments) {
            double grade = gradeCalculator.calculateNumericGrade(enrollment);
            sum += grade;
            if (grade < min) min = grade;
            if (grade > max) max = grade;
        }

        double average = sum / enrollments.size();

        System.out.println("----------------------------------------");
        System.out.println("Course Statistics:");
        System.out.println("  Average: " + String.format("%.2f", average) + "%");
        System.out.println("  Highest: " + String.format("%.2f", max) + "%");
        System.out.println("  Lowest: " + String.format("%.2f", min) + "%");
        System.out.println("========================================");
    }
}
