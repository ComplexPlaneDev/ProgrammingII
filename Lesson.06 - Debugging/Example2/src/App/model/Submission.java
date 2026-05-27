package App.model;

public class Submission {
    private Assignment assignment;
    private double pointsEarned;

    public Submission(Assignment assignment, double pointsEarned) {
        this.assignment = assignment;
        this.pointsEarned = pointsEarned;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public double getPointsEarned() {
        return pointsEarned;
    }

    public double getPercentage() {
        return (pointsEarned / assignment.getMaxPoints()) * 100;
    }
}
