import java.util.Date;
import java.util.Objects;
import java.time.LocalDate;

class Employee {
    // instance fields
    private int id;
    private String name;
    private double salary;
    private LocalDate hireDay;
    private Date endDay;

    // static field belong to the class, not the instance!!!
    private static int baseId = 1;

    // constructors => HAVE THE SAME NAME OF THE CLASS
    // - can be called only via new (not 100% true, but we'll see that in the ASE course)
    // - they cannot be called again once the object is constructed, i.e. to initialize it again
    // - don't have a return type

    // If you don't set a field here, it will be automatically initialized to the default value
    // DON'T EVER EVER EVER DO THAT!!!!

    // Constructors are NOT mandatory
    Employee(String n, double s, int year, int month, int day) {
        id = Employee.getNextId();

        // when possible, make a clear statement about which fields can be null or not
        name = Objects.requireNonNullElse(n, "unknown");
        salary = s;
        hireDay = LocalDate.of(year, month, day);
        endDay = new Date((year - 1900) + 3, month - 1, day);
    }

    // constructors, as all other methods, can be overloaded
    // a method can be overloaded only if there's a difference either in the number of parameters or their types
    // the return type does not play a role!!!!
    Employee(String n, double s, int year) {
        id = Employee.getNextId();

        name = Objects.requireNonNull(n, "The name cannot be null");
        salary = s;
        hireDay = LocalDate.of(year, 1, 1);
        endDay = null;

        // a constructor can also call another constructor: this(.., .., ...)
    }

    // accessors
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

    // mutators
    void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100; // salary here is an implicit argument, i.e. it uses THIS
        salary += raise;
    }

    void raiseSalary() {
        double raise = this.salary * 10 / 100; // here we make it explicit
        this.salary += raise;
    }

    private static int getNextId() {
        // we cannot access instance fields here, we're static, we cannot operate on objects
        // String s = this.getName();

        return Employee.baseId++;
    }
}
