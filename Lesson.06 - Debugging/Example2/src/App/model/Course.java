package App.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String code;
    private String name;
    private List<Assignment> assignments;

    public Course(String code, String name) {
        this.code = code;
        this.name = name;
        this.assignments = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public double getTotalWeight() {
        double total = 0;
        for (Assignment a : assignments) {
            total += a.getWeight();
        }
        return total;
    }
}
