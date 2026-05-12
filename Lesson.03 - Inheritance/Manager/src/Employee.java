import java.util.Date;
import java.util.Objects;
import java.time.LocalDate;

class Employee {
    private int id;
    private String name;
    private double salary;
    private LocalDate hireDay;
    private Date endDay;

    private static int baseId = 1;

    Employee(String n, double s, int year, int month, int day) {
        id = Employee.getNextId();

        name = Objects.requireNonNullElse(n, "unknown");
        salary = s;
        hireDay = LocalDate.of(year, month, day);
        endDay = new Date((year - 1900) + 3, month - 1, day);
    }

    Employee(String n, double s, int year) {
        id = Employee.getNextId();

        name = Objects.requireNonNull(n, "The name cannot be null");
        salary = s;
        hireDay = LocalDate.of(year, 1, 1);
        endDay = null;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    double getSalary() {
        return salary;
    }

    LocalDate getHireDay() {
        return hireDay;
    }

    Date getEndDay() {
        return endDay;
    }

    void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    void raiseSalary() {
        double raise = this.salary * 10 / 100;
        this.salary += raise;
    }

    private static int getNextId() {
        return Employee.baseId++;
    }
}
