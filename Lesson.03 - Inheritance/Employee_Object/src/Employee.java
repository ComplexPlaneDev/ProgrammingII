import java.util.Objects;

class Employee {
    private int id;
    private String name;
    private double salary;

    Employee(int id, String n, double s) {
        this.id = id;
        this.name = Objects.requireNonNull(n, "The name cannot be null");
        this.salary = s;
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

    /*
    @Override
    public boolean equals(Object e) {
        if (!(e instanceof Employee)) {
            return false;
        }

        final Employee emp = (Employee) e;
        return id == emp.id;
    }

    @Override
    public String toString() {
        return "id = " + getId() + ", name = " + getName();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(getId());
    }
    */
}
