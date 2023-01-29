package Human;

import java.util.Date;

public abstract class Employee extends Person {

    private double remainingVacations;
    private double salary;
    public Employee(String name, int age, Date date, double salary,String userName,String password) {
        super(name, age, date, userName, password);
        this.remainingVacations = 20.0;
        this.salary = salary;
    }


    protected double getSalary() {
        return salary;
    }

    protected void setSalary(double salary) {
        this.salary = salary;
    }

    protected double getRemainingVacations() {
        return remainingVacations;
    }

    protected void setRemainingVacations(double remainingVacations) {
        this.remainingVacations = remainingVacations;
    }

    protected void takeVacations() {

    }
}
