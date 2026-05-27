package App.model;

import java.util.ArrayList;
import java.util.List;

public class Enrollment {
    private Student student;
    private Course course;
    private List<Submission> submissions;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.submissions = new ArrayList<>();
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public void addSubmission(Submission submission) {
        submissions.add(submission);
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public Submission getSubmissionFor(Assignment assignment) {
        for (Submission s : submissions) {
            if (s.getAssignment().getName().equals(assignment.getName())) {
                return s;
            }
        }
        return null;
    }
}
