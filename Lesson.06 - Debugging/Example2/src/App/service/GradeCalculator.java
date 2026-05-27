package App.service;

import App.model.Enrollment;

public class GradeCalculator {
    private WeightedScoreCalculator weightedScoreCalculator;
    private GradeConverter gradeConverter;

    public GradeCalculator() {
        this.weightedScoreCalculator = new WeightedScoreCalculator();
        this.gradeConverter = new GradeConverter();
    }

    public double calculateNumericGrade(Enrollment enrollment) {
        return processEnrollmentGrade(enrollment);
    }

    private double processEnrollmentGrade(Enrollment enrollment) {
        return computeFinalScore(enrollment);
    }

    private double computeFinalScore(Enrollment enrollment) {
        return weightedScoreCalculator.computeTotalWeightedScore(enrollment);
    }

    public String calculateLetterGrade(Enrollment enrollment) {
        double numericGrade = calculateNumericGrade(enrollment);
        return gradeConverter.convertToLetterGrade(numericGrade);
    }

    public double calculateGradePoints(Enrollment enrollment) {
        String letterGrade = calculateLetterGrade(enrollment);
        return gradeConverter.convertToGradePoints(letterGrade);
    }
}
