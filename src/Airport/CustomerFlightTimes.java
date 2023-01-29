package Airport;

import java.util.Date;

public class CustomerFlightTimes extends FlightTime {

    public CustomerFlightTimes(Date flyingTime, Date arriveTime, String flightDestination, double ticketPrice) {
        super(flyingTime, arriveTime, flightDestination, ticketPrice);
    }
}
