package App;

import App.data.DataLoader;
import App.model.Course;
import App.model.Enrollment;
import App.model.Student;
import App.report.CourseReportGenerator;
import App.report.TranscriptGenerator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader();

        List<Student> students = dataLoader.loadStudents();
        List<Course> courses = dataLoader.loadCourses();
        dataLoader.createEnrollments(students, courses);

        TranscriptGenerator transcriptGenerator = new TranscriptGenerator();
        CourseReportGenerator courseReportGenerator = new CourseReportGenerator();

        System.out.println("\n*** STUDENT TRANSCRIPTS ***\n");

        for (Student student : students) {
            transcriptGenerator.generateTranscript(student);
            System.out.println();
        }

        System.out.println("\n*** COURSE REPORTS ***\n");

        for (Course course : courses) {
            List<Enrollment> courseEnrollments = getEnrollmentsForCourse(students, course);
            courseReportGenerator.generateCourseReport(course, courseEnrollments);
            System.out.println();
        }

        printExpectedGrades();
    }

    private static List<Enrollment> getEnrollmentsForCourse(List<Student> students, Course course) {
        List<Enrollment> enrollments = new ArrayList<>();
        for (Student student : students) {
            for (Enrollment enrollment : student.getEnrollments()) {
                if (enrollment.getCourse().getCode().equals(course.getCode())) {
                    enrollments.add(enrollment);
                }
            }
        }
        return enrollments;
    }

    private static void printExpectedGrades() {
        System.out.println("\n========================================");
        System.out.println("    EXPECTED GRADES (Manual Calculation)");
        System.out.println("========================================");
        System.out.println("\nCS201 - Object-Oriented Programming:");
        System.out.println("  Weights: HW1=10%, HW2=10%, Midterm=25%, Project=20%, Final=35%");
        System.out.println();
        System.out.println("  Alice: (95*0.10)+(92*0.10)+(88*0.25)+(90*0.20)+(94*0.35) = 91.60%");
        System.out.println("  Bob:   (78*0.10)+(82*0.10)+(75*0.25)+(80*0.20)+(77*0.35) = 77.70%");
        System.out.println("  Carol: (100*0.10)+(98*0.10)+(95*0.25)+(97*0.20)+(99*0.35) = 97.80%");
        System.out.println();
        System.out.println("CS202 - Database Systems:");
        System.out.println("  Weights: Lab1=10%, Lab2=10%, Lab3=10%, Midterm=30%, Final=40%");
        System.out.println();
        System.out.println("  Alice: (96*0.10)+(90*0.10)+(94*0.10)+(85*0.30)+(92*0.40) = 90.30%");
        System.out.println("  Bob:   (80*0.10)+(84*0.10)+(76*0.10)+(72*0.30)+(75*0.40) = 75.60%");
        System.out.println("  Carol: (100*0.10)+(98*0.10)+(100*0.10)+(95*0.30)+(98*0.40) = 97.50%");
        System.out.println("========================================");
    }
}
