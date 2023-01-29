package Service;
import Airport.Airplane;
import Airport.Airport;
import Airport.AirportFlightTime;
import Human.Customer;
import Human.Employee;
import java.util.ArrayList;
import java.util.Scanner;
import Airport.CustomerFlightTimes;
import static Service.Services.convertStringToDate;

public class ControlAirport {
    final protected ControlAirport.ControlAirplane controlAirplane = new ControlAirport.ControlAirplane();
    final protected ControlAirport.ControlAirplaneFlightTimes controlAirplaneFlightTimes = new ControlAirport.ControlAirplaneFlightTimes();
    final protected ControlAirport.ControlAirportEmployee controlAirportEmployee = new ControlAirport.ControlAirportEmployee();
    final protected ControlAirport.ControlAirportCustomer controlAirportCustomer = new ControlAirport.ControlAirportCustomer();
    final private ArrayList<Airplane> airplanes = new ArrayList<>();
    final private ArrayList<AirportFlightTime> airportFlightTimes = new ArrayList<>();
    final private ArrayList<Employee> employees = new ArrayList<>();
    final private ArrayList<Customer> customers = new ArrayList<>();

    public ControlAirport.ControlAirplane accessControlAirplane(){
        return controlAirplane;
    }
    public ControlAirport.ControlAirplaneFlightTimes accessControlAirplaneFlightTimes(){
        return controlAirplaneFlightTimes;
    }
    public ControlAirport.ControlAirportEmployee accessControlAirportEmployee(){
        return controlAirportEmployee;
    }
    public ControlAirport.ControlAirportCustomer accessControlAirportCustomer(){
        return controlAirportCustomer;
    }
    public class ControlAirplane {
        public void addNewPlane(Airplane airplane) {
            airplanes.add(airplane);
        }
        public void addNewPlane() {
            int option;
            Enumeration.AirplaneNames airplaneName;

            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.println("Airplane name : ");
                Enumeration.AirplaneNames[] airplaneNames = Enumeration.AirplaneNames.values();
                for(int i = 0; i<airplaneNames.length ; i++ ) {
                    System.out.println("To use " + airplaneNames[i] + " press " + (i+1));
                }
                System.out.print("Your option : ");
                option = scanner.nextInt();
                if(option > 0 && option <= airplaneNames.length) {
                    airplaneName = airplaneNames[option-1];
                    break;
                }
                System.out.println("Wrong option please retry other option");
            }
            System.out.print("Airplane number : ");
            int airplaneNumber = scanner.nextInt();
            System.out.print("Number of seats : ");
            int numberOfSeats = scanner.nextInt();
            System.out.print("Number of VIP seats : ");
            int numberOfVIPSeats = scanner.nextInt();
            System.out.print("Max weight : ");
            double maxPayloadWeight = scanner.nextDouble();
            airplanes.add(new Airplane(airplaneName,airplaneNumber,numberOfSeats,numberOfVIPSeats,maxPayloadWeight));
        }
        public void removePlane() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter airplane number : ");
            int airplaneNumber = scanner.nextInt();
            makeAsAvailable(airplaneNumber);
            airplanes.removeIf(airplane -> airplane.getAirplaneNumber() == airplaneNumber);
        }
        public int getNextAvailableAirplane() {
            for(Airplane airplane:airplanes) {
                if(airplane.isAvailable())
                    return airplane.getAirplaneNumber();
            }
            return 0;
        }
        public int getAirplaneNumber(){
            return airplanes.size();
        }

        public void showAllPlane() {
            System.out.println("  Airplane number   |        Airplane name      |       Max load weight       |      Number Of Seats      |      Number Of VIP Seats     |     Availability     ");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for(Airplane airplane: airplanes) {
                System.out.println(airplane.getAirplaneNumber() + "                 | " + airplane.getName() + "                       | " + airplane.getMaxPayloadWeight() + " K.G                  | " + airplane.getNumberOfSeats() + "                       | " + airplane.getNumberOfVIPSeats() + "                           | " + (airplane.isAvailable() ? "Available" : "Not Available"));
            }
        }
        public void makeAsAvailable(int airplaneNumber){
            for(Airplane airplane:airplanes) {
                if(airplane.getAirplaneNumber() == airplaneNumber)
                {
                    airplane.setAvailable(true);
                }
            }
        }
        public void makeAsNotAvailable(int airplaneNumber){
            for(Airplane airplane:airplanes) {
                if(airplane.getAirplaneNumber() == airplaneNumber)
                {
                    airplane.setAvailable(false);
                }
            }
        }
    }
    public class ControlAirplaneFlightTimes {
        public void addNewFlying(AirportFlightTime airportFlightTime) {
            airportFlightTimes.add(airportFlightTime);
        }
        public void addNewFlying(Airport airport) {
            if(controlAirplane.getNextAvailableAirplane() == 0) {
                System.out.println("Error no available plane now");
                return;
            }
            Scanner scanner = new Scanner(System.in);
            System.out.print("Flaying time as yyyy/MM/dd/hh:mm:ss : ");
            String flyingTime = scanner.next();
            System.out.print("Arrive time as yyyy/MM/dd/hh:mm:ss : ");
            String arriveTime = scanner.next();
            System.out.print("Flight Destination : ");
            String flightDestination = scanner.next();
            System.out.print("Ticket price : ");
            double ticketPrice = scanner.nextDouble();
            controlAirplaneFlightTimes.addNewFlying(new AirportFlightTime(airport,convertStringToDate(flyingTime),convertStringToDate(arriveTime),flightDestination,ticketPrice));
        }
        public void removeFlying() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the trip number : ");
            int tripNumber = scanner.nextInt();
            int airplaneNumber = 0;
            airportFlightTimes.removeIf(flight -> flight.getTripNumber() == tripNumber);
            for(AirportFlightTime airportFlightTime:airportFlightTimes)
            {
                if(airportFlightTime.getTripNumber() == tripNumber)
                    airportFlightTimes.remove(airportFlightTime);
                airplaneNumber = airportFlightTime.getAirplaneNumber();
            }
            controlAirplane.makeAsAvailable(airplaneNumber);
        }
        public void showAllFlight()
        {
            System.out.println("Flight number    |     Airplane number   |          Flight Time          |          Flight Arrive          |          Destination          |         Ticket Price  ");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            for(AirportFlightTime airportFlightTime:airportFlightTimes)
            {
                System.out.println(airportFlightTime.getTripNumber() +"                | "+ airportFlightTime.getAirplaneNumber() + "                 | " + airportFlightTime.getFlyingTime() + "  |  " +airportFlightTime.getArriveTime() + "   | " + airportFlightTime.getFlightDestination() + "                     | " + airportFlightTime.getTicketPrice());
            }
        }
    }
    public class ControlAirportEmployee {
        public void addNewEmployee(Employee employee) {
            employees.add(employee);
        }
        public void removeEmployee(Employee employee) {
            employees.remove(employee);
        }
        public void addNewEmployee() {

        }
        public void removeEmployee() {

        }
        public int getNumberOfEmployee() {
            return employees.size();
        }
    }
    public class ControlAirportCustomer {
        public void addNewCustomer(Customer customer) {
            customers.add(customer);
        }
        public void removeCustomer(Customer customer) {
            customers.remove(customer);
        }
        public void takeANewTrip(int customerID) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter the trip number : ");
            int tripNumber = scanner.nextInt();
            for(Customer customer:customers){
                if(customer.getId() == customerID)
                {
                    for(AirportFlightTime airportFlightTime:airportFlightTimes)
                    {
                        if(airportFlightTime.getTripNumber() == tripNumber)
                        {
                            customer.addNewFlight(new CustomerFlightTimes(airportFlightTime.getFlyingTime(),airportFlightTime.getArriveTime(),airportFlightTime.getFlightDestination(),airportFlightTime.getTicketPrice()));
                        }
                    }
                }
            }
        }
        public void cancelATrip(int customerID){
            Scanner scanner = new Scanner(System.in);
            int tripNumber = scanner.nextInt();
            System.out.print("Enter the trip number : ");
            for(Customer customer:customers)
            {
                if(customer.getId() == customerID)
                {
                    customer.cancelATrip(tripNumber);
                }
            }
        }

        public void showAllCustomerFlight(int customerID) {
            for(Customer customer:customers){
                if(customer.getId() == customerID)
                {
                    customer.showAllCustomerFlight();
                }
            }
        }

        public int login(String userName,String password)
        {
            for(Customer customer:customers){
                if(customer.getUserName().equals(userName) && (customer.getPassword().equals(password)))
                {
                    return customer.getId();
                }
            }
            return -1;
        }
    }
}
