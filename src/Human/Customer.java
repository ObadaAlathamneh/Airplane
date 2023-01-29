package Human;
import Airport.CustomerFlightTimes;
import java.util.ArrayList;
import java.util.Date;

public class Customer extends Person {
    private int flyNumber;
    ArrayList<CustomerFlightTimes> customerFlightTimes = new ArrayList<>();
    public Customer(String name, int age, Date date, int flyNumber,String userName,String password) {
        super(name, age, date, userName, password);
        this.flyNumber = flyNumber;
    }

    @Override
    protected double getDiscount() {
        double discount = 0.1 * flyNumber;
        if(discount > 20)
            discount = 20;
        return discount;
    }

    public int getFlyNumber() {
        return flyNumber;
    }
    public void setFlyNumber(int flyNumber) {
        this.flyNumber = flyNumber;
    }
    public void addNewFlight(CustomerFlightTimes customerFlightTime) {
        customerFlightTimes.add(customerFlightTime);
        setFlyNumber(getFlyNumber()+1);
    }
    public void cancelATrip(int tripNumber) {
        customerFlightTimes.removeIf(fly -> fly.getTripNumber() == tripNumber);
    }
    public void showAllCustomerFlight()
    {
        System.out.println("--------------------------");
        for(CustomerFlightTimes customerFlightTime : customerFlightTimes){
            System.out.println(customerFlightTime.getTripNumber() + " " + customerFlightTime.getFlyingTime() + customerFlightTime.getArriveTime() + customerFlightTime.getFlightDestination() + customerFlightTime.getTicketPrice());
        }
        System.out.println("--------------------------");
    }
}
