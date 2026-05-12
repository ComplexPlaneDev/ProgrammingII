package com.github.prog2;

import java.util.Date;
import java.util.Random;
import java.time.LocalDate;

// public final class Employee extends Person {
public class Employee extends Person {
    private int id;
    private double salary;
    private LocalDate hireDay;
    private Date endDay;

    private static int baseId = 1;

    public Employee(String n, double s, int year, int month, int day) {
        super(n);

        id = Employee.getNextId();
        salary = s;
        hireDay = LocalDate.of(year, month, day);
        endDay = new Date((year - 1900) + 3, month - 1, day);
    }

    public Employee(String n, double s, int year) {
        super(n);

        id = Employee.getNextId();
        salary = s;
        hireDay = LocalDate.of(year, 1, 1);
        endDay = null;
    }

    // accessors
    public int getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return "I'm an employee";
    }

    protected String locateOffice() {
        // ... assume we're accessing a complicated resource ...
        final String offices[] = { "A1-31", "B2-19", "C0-03", "D4-11" };
        return offices[new Random().nextInt(offices.length)];
    }

    public String getOffice() {
        return "EPY-" + locateOffice();
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public void raiseSalary() {
        double raise = this.salary * 10 / 100;
        this.salary += raise;
    }

    private static int getNextId() {
        return Employee.baseId++;
    }
}
