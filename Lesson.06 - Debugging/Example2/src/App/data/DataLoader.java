package App.data;

import App.model.*;

import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    public List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("S001", "Alice Johnson"));
        students.add(new Student("S002", "Bob Smith"));
        students.add(new Student("S003", "Carol Williams"));
        return students;
    }

    public List<Course> loadCourses() {
        List<Course> courses = new ArrayList<>();

        Course cs201 = createProgrammingCourse();
        Course cs202 = createDatabaseCourse();

        courses.add(cs201);
        courses.add(cs202);

        return courses;
    }

    private Course createProgrammingCourse() {
        Course course = new Course("CS201", "Object-Oriented Programming");
        course.addAssignment(new Assignment("Homework 1", 100, 10));
        course.addAssignment(new Assignment("Homework 2", 100, 10));
        course.addAssignment(new Assignment("Midterm Exam", 100, 25));
        course.addAssignment(new Assignment("Project", 100, 20));
        course.addAssignment(new Assignment("Final Exam", 100, 35));
        return course;
    }

    private Course createDatabaseCourse() {
        Course course = new Course("CS202", "Database Systems");
        course.addAssignment(new Assignment("Lab 1", 50, 10));
        course.addAssignment(new Assignment("Lab 2", 50, 10));
        course.addAssignment(new Assignment("Lab 3", 50, 10));
        course.addAssignment(new Assignment("Midterm", 100, 30));
        course.addAssignment(new Assignment("Final Project", 100, 40));
        return course;
    }

    public void createEnrollments(List<Student> students, List<Course> courses) {
        Course cs201 = courses.get(0);
        Course cs202 = courses.get(1);

        setupAliceEnrollments(students.get(0), cs201, cs202);
        setupBobEnrollments(students.get(1), cs201, cs202);
        setupCarolEnrollments(students.get(2), cs201, cs202);
    }

    private void setupAliceEnrollments(Student student, Course cs201, Course cs202) {
        Enrollment e1 = createEnrollmentWithScores(student, cs201,
            new double[]{95, 92, 88, 90, 94});
        student.addEnrollment(e1);

        Enrollment e2 = createEnrollmentWithScores(student, cs202,
            new double[]{48, 45, 47, 85, 92});
        student.addEnrollment(e2);
    }

    private void setupBobEnrollments(Student student, Course cs201, Course cs202) {
        Enrollment e1 = createEnrollmentWithScores(student, cs201,
            new double[]{78, 82, 75, 80, 77});
        student.addEnrollment(e1);

        Enrollment e2 = createEnrollmentWithScores(student, cs202,
            new double[]{40, 42, 38, 72, 75});
        student.addEnrollment(e2);
    }

    private void setupCarolEnrollments(Student student, Course cs201, Course cs202) {
        Enrollment e1 = createEnrollmentWithScores(student, cs201,
            new double[]{100, 98, 95, 97, 99});
        student.addEnrollment(e1);

        Enrollment e2 = createEnrollmentWithScores(student, cs202,
            new double[]{50, 49, 50, 95, 98});
        student.addEnrollment(e2);
    }

    private Enrollment createEnrollmentWithScores(Student student, Course course, double[] scores) {
        Enrollment enrollment = new Enrollment(student, course);
        List<Assignment> assignments = course.getAssignments();

        for (int i = 0; i < assignments.size(); i++) {
            Submission submission = new Submission(assignments.get(i), scores[i]);
            enrollment.addSubmission(submission);
        }

        return enrollment;
    }
}
