package App.model;

public class Assignment {
    private String name;
    private double maxPoints;
    private double weight;

    public Assignment(String name, double maxPoints, double weight) {
        this.name = name;
        this.maxPoints = maxPoints;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getMaxPoints() {
        return maxPoints;
    }

    public double getWeight() {
        return weight;
    }
}
