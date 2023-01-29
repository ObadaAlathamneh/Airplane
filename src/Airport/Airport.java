package Airport;
import Service.ControlAirport;
import java.util.Date;

import static Service.Services.convertStringToDate;

public class Airport {
    private final String name;
    private final Date creationDate;
    private final ControlAirport controlAirport = new ControlAirport();
    public Airport(String name, String creationDate) {
        this.name = name;
        this.creationDate = convertStringToDate(creationDate);
    }
    private String getName() {
        return name;
    }
    private Date getCreationDate() {
        return creationDate;
    }

    public ControlAirport getAccess(){
        return controlAirport;
    }

    public void printInfo() {
        System.out.println("Name :               " + getName());
        System.out.println("Creation date :      " + getCreationDate());
        System.out.println("Number Of Plane :    " + controlAirport.accessControlAirplane().getAirplaneNumber());
        System.out.println("Number Of Employee : " + controlAirport.accessControlAirportEmployee().getNumberOfEmployee());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        controlAirport.accessControlAirplaneFlightTimes().showAllFlight();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        controlAirport.accessControlAirplane().showAllPlane();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    }
}
