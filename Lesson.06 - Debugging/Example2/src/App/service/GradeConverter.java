package App.service;

public class GradeConverter {

    public String convertToLetterGrade(double numericGrade) {
        return determineGradeBracket(numericGrade);
    }

    private String determineGradeBracket(double grade) {
        if (grade >= 90) {
            return processHighGrade(grade);
        } else if (grade >= 80) {
            return processMediumHighGrade(grade);
        } else if (grade >= 70) {
            return processMediumGrade(grade);
        } else if (grade >= 60) {
            return processMediumLowGrade(grade);
        } else {
            return processLowGrade(grade);
        }
    }

    private String processHighGrade(double grade) {
        if (grade >= 97) return "A+";
        if (grade >= 93) return "A";
        return "A-";
    }

    private String processMediumHighGrade(double grade) {
        if (grade >= 87) return "B+";
        if (grade >= 83) return "B";
        return "B-";
    }

    private String processMediumGrade(double grade) {
        if (grade >= 77) return "C+";
        if (grade >= 73) return "C";
        return "C-";
    }

    private String processMediumLowGrade(double grade) {
        if (grade >= 67) return "D+";
        if (grade >= 63) return "D";
        return "D-";
    }

    private String processLowGrade(double grade) {
        return "F";
    }

    public double convertToGradePoints(String letterGrade) {
        return switch (letterGrade) {
            case "A+" -> 4.0;
            case "A" -> 4.0;
            case "A-" -> 3.7;
            case "B+" -> 3.3;
            case "B" -> 3.0;
            case "B-" -> 2.7;
            case "C+" -> 2.3;
            case "C" -> 2.0;
            case "C-" -> 1.7;
            case "D+" -> 1.3;
            case "D" -> 1.0;
            case "D-" -> 0.7;
            default -> 0.0;
        };
    }
}
