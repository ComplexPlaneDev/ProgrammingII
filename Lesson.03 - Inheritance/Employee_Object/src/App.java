public class App {
    public static void main(String[] args) throws Exception {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee(1, "Alice", 75000);
        staff[1] = new Employee(2, "Bob", 50000);
        staff[2] = new Employee(1, "Alice", 75000);

        System.out.println(staff[0].equals(staff[2]));

        System.out.println(staff[0].toString());

        System.out.println(String.valueOf(staff[0].hashCode()) + ", " + String.valueOf(staff[2].hashCode()));
    }
}
