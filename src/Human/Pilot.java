package Human;

import java.util.Date;

public class Pilot extends Employee {

    private double hourFlying;

    public Pilot(String name, int age, Date date, double salary, double hourFlying,String userName, String password) {
        super(name, age, date, salary,userName,password);
        this.hourFlying = hourFlying;
    }

    @Override
    public double getDiscount() {
        return 0;
    }

    public double getHourFlying() {
        return hourFlying;
    }

    public void setHourFlying(int hourFlying) {
        this.hourFlying = hourFlying;
    }
}
