package Human;

import java.util.Date;

public class AirHostess extends Employee {

    private double yearOfExperience;
    public double getYearOfExperience() {
        return yearOfExperience;
    }
    public void setYearOfExperience(double yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }
    public AirHostess(String name, int age, Date date, double salary, double yearOfExperience,String userName,String password) {
        super(name, age, date, salary,userName,password);
        this.yearOfExperience = yearOfExperience;
    }

    @Override
    public double getDiscount() {
        double discount = 5 * yearOfExperience;
        if(discount > 50)
            discount = 50;
        return discount;
    }
}
