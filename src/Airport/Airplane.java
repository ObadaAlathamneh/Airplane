package Airport;

import Service.Enumeration;

public class Airplane {
    final private Enumeration.AirplaneNames name;
    final private int airplaneNumber;
    final private int numberOfSeats;
    final private int numberOfVIPSeats;
    final private double maxPayloadWeight;
    private boolean available;

    public Airplane(Enumeration.AirplaneNames name, int airplaneNumber, int numberOfSeats, int numberOfVIPSeats, double maxPayloadWeight) {
        this.name = name;
        this.airplaneNumber = airplaneNumber;
        this.numberOfSeats = numberOfSeats;
        this.numberOfVIPSeats = numberOfVIPSeats;
        this.maxPayloadWeight = maxPayloadWeight;
        this.available = true;
    }
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public int getNumberOfVIPSeats() {
        return numberOfVIPSeats;
    }
    public double getMaxPayloadWeight() {
        return maxPayloadWeight;
    }
    public Enumeration.AirplaneNames getName() {
        return name;
    }
    public int getAirplaneNumber() {
        return airplaneNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
