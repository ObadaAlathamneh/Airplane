package Airport;

import java.util.Date;

public class AirportFlightTime extends FlightTime {
    private final int airplaneNumber;

    public AirportFlightTime(Airport airport,Date flyingTime, Date arriveTime, String flightDestination, double ticketPrice) {
        super(flyingTime, arriveTime, flightDestination, ticketPrice);
        airplaneNumber = airport.getAccess().accessControlAirplane().getNextAvailableAirplane();
        airport.getAccess().accessControlAirplane().makeAsNotAvailable(airplaneNumber);
    }
    public int getAirplaneNumber() {
        return airplaneNumber;
    }
}