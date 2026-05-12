class Manager extends Employee {
    private double bonus;

    Manager(String n, double s, int year) {
        super(n, s, year);

        bonus = 0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalary() {
        return super.getSalary() + bonus;
    }
}
