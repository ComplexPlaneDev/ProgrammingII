package com.github.prog2;

public class Manager extends Employee {
    private double bonus;

    public Manager(String n, double s, int year) {
        super(n, s, year);

        bonus = 0;
    }

    @Override
    public String getDescription() {
        return "I'm a manager";
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalary() {
        return super.getSalary() + bonus;
    }

    public String getOffice() {
        return "MGR-" + locateOffice();
    }
}
