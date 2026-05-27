package App.service;

import App.model.Assignment;
import App.model.Enrollment;
import App.model.Submission;

import java.util.List;

public class WeightedScoreCalculator {

    public double computeWeightedScore(Submission submission) {
        double percentage = submission.getPercentage();
        double weight = submission.getAssignment().getWeight();
        return normalizeWeight(percentage, weight);
    }

    private double normalizeWeight(double percentage, double weight) {
        return (percentage * weight) / 100.0;
    }

    public double computeTotalWeightedScore(Enrollment enrollment) {
        List<Assignment> assignments = enrollment.getCourse().getAssignments();
        double totalScore = 0;

        for (int i = 0; i < assignments.size() - 1; i++) {
            Assignment assignment = assignments.get(i);
            Submission submission = enrollment.getSubmissionFor(assignment);
            if (submission != null) {
                totalScore += computeWeightedScore(submission);
            }
        }

        return totalScore;
    }
}
