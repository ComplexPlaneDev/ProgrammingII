import com.github.prog2.Employee;
import com.github.prog2.Manager;
import com.github.prog2.Person;
import com.github.prog2.Student;

public class App {
    public static void main(String[] args) throws Exception {
        Person[] people = new Person[4];

        people[0] = new Employee("Alice", 75000, 1987, 12, 15);
        people[1] = new Employee("Bob", 50000, 1989, 10, 1);
        people[2] = new Student("Frida");
        people[3] = new Manager("Charlie", 130000, 1980);

        // Cannot instantiate abstract classes
        // people[3] = new Person("Philip");

        for (Person p : people) {
            System.out.println("name=" + p.getName() + ", description=" + p.getDescription());
        }
    }
}
