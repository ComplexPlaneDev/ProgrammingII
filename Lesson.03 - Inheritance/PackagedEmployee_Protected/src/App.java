import java.util.Date;
import com.github.prog2.Employee;
import com.github.prog2.Manager;

public class App {
    public static void main(String[] args) throws Exception {
        Employee[] staff = new Employee[4];

        staff[0] = new Employee("Alice", 75000, 1987, 12, 15);
        staff[1] = new Employee("Bob", 50000, 1989, 10, 1);
        staff[2] = new Employee("Frida", 40000, 1990);
        staff[3] = new Manager("Charlie", 130000, 1980);

        System.out.println("BEFORE RAISE");
        for (Employee e : staff) {
            System.out.println("id=" + e.getId() + ", name=" + e.getName() + ", salary=" + e.getSalary()
                + ", hireDay=" + e.getHireDay() + ", endDay = " + e.getEndDay() + ", office = " + e.getOffice());
        }

        // NOT VISIBLE
        // var office = staff[0].locateOffice();

        for (Employee e : staff) {
            e.raiseSalary(5);
        }
        staff[0].raiseSalary();

        Date endDate = staff[0].getEndDay();
        if (endDate != null) {
            endDate.setYear(endDate.getYear() + 10);
        }

        System.out.println("AFTER RAISE");
        for (Employee e : staff) {
            System.out.println("id=" + e.getId() + ", name=" + e.getName() + ", salary=" + e.getSalary()
                + ", hireDay=" + e.getHireDay() + ", endDay = " + e.getEndDay());
        }
    }
}
