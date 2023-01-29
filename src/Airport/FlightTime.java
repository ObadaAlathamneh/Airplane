package Airport;

import java.util.Date;

public abstract class FlightTime {
    private static int count = 0;
    final private int tripNumber;
    final private Date flyingTime;
    final private Date arriveTime;
    final private String flightDestination;
    final private double ticketPrice;

    protected FlightTime(Date flyingTime, Date arriveTime, String flightDestination, double ticketPrice) {
        this.tripNumber = ++count;
        this.flyingTime = flyingTime;
        this.arriveTime = arriveTime;
        this.flightDestination = flightDestination;
        this.ticketPrice = ticketPrice;
    }
    public Date getFlyingTime() {
        return flyingTime;
    }
    public Date getArriveTime() {
        return arriveTime;
    }
    public String getFlightDestination() {
        return flightDestination;
    }
    public double getTicketPrice() {
        return ticketPrice;
    }
    public int getTripNumber() {
        return tripNumber;
    }

}
