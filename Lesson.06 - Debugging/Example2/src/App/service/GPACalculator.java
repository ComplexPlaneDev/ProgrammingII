package App.service;

import App.model.Enrollment;
import App.model.Student;

import java.util.List;

public class GPACalculator {
    private GradeCalculator gradeCalculator;

    public GPACalculator() {
        this.gradeCalculator = new GradeCalculator();
    }

    public double calculateGPA(Student student) {
        return processStudentGPA(student);
    }

    private double processStudentGPA(Student student) {
        List<Enrollment> enrollments = student.getEnrollments();
        return computeAverageGradePoints(enrollments);
    }

    private double computeAverageGradePoints(List<Enrollment> enrollments) {
        if (enrollments.isEmpty()) {
            return 0.0;
        }

        double totalPoints = 0;
        for (Enrollment enrollment : enrollments) {
            totalPoints += calculateEnrollmentGradePoints(enrollment);
        }

        return totalPoints / enrollments.size();
    }

    private double calculateEnrollmentGradePoints(Enrollment enrollment) {
        return gradeCalculator.calculateGradePoints(enrollment);
    }
}
