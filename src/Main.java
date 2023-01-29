import Airport.Airplane;
import Airport.Airport;
import Airport.AirportFlightTime;
import Human.AirHostess;
import Human.Customer;
import Human.Pilot;
import Service.Enumeration;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static Service.Services.convertStringToDate;

public class Main {

    static void start(Airport airport) {

        airport.getAccess().accessControlAirplane().addNewPlane(new Airplane(Enumeration.AirplaneNames.F16,987,150,15,1790));
        airport.getAccess().accessControlAirplane().addNewPlane(new Airplane(Enumeration.AirplaneNames.F17,986,150,15,1790));
        airport.getAccess().accessControlAirplane().addNewPlane(new Airplane(Enumeration.AirplaneNames.F16,985,150,15,1790));
        airport.getAccess().accessControlAirplane().addNewPlane(new Airplane(Enumeration.AirplaneNames.F17,984,150,15,1790));

        airport.getAccess().accessControlAirplaneFlightTimes().addNewFlying(new AirportFlightTime(airport,convertStringToDate("2023/01/01/12:00:00"),convertStringToDate("2023/01/01/13:00:00"),"Saudi Arabia",15.8));
        airport.getAccess().accessControlAirplaneFlightTimes().addNewFlying(new AirportFlightTime(airport,convertStringToDate("2023/01/04/05:30:00"),convertStringToDate("2023/01/04/07:15:00"),"USA"         ,130 ));
        airport.getAccess().accessControlAirplaneFlightTimes().addNewFlying(new AirportFlightTime(airport,convertStringToDate("2023/01/02/09:00:00"),convertStringToDate("2023/01/02/10:00:00"),"Iraq"        ,45  ));
        airport.getAccess().accessControlAirplaneFlightTimes().addNewFlying(new AirportFlightTime(airport,convertStringToDate("2023/01/07/03:00:00"),convertStringToDate("2023/01/07/06:00:00"),"Australia"   ,115 ));

        airport.getAccess().accessControlAirportEmployee().addNewEmployee(new Pilot("Ahmad",39,convertStringToDate("1984/05/17/00:00:00"),1700,1600,"",""));
        airport.getAccess().accessControlAirportEmployee().addNewEmployee(new Pilot("Omar" ,52,convertStringToDate("1971/09/03/00:00:00"),2600,3000,"",""));
        airport.getAccess().accessControlAirportEmployee().addNewEmployee(new AirHostess("Samia",28,convertStringToDate("1995/12/09/00:00:00"),1000,3,"",""));
        airport.getAccess().accessControlAirportEmployee().addNewEmployee(new AirHostess("Sara",28,convertStringToDate("1995/12/09/00:00:00"),1000,3,"",""));
        airport.getAccess().accessControlAirportEmployee().addNewEmployee(new AirHostess("Hamed",28,convertStringToDate("1995/12/09/00:00:00"),1000,3,"",""));
        airport.getAccess().accessControlAirportEmployee().addNewEmployee(new Pilot("Shadi",40,convertStringToDate("1983/01/01/00:00:00"),1750,1800,"",""));
        airport.getAccess().accessControlAirportCustomer().addNewCustomer(new Customer("OPADA",23,convertStringToDate("1999/10/7"),15,"OPADA","OPADA"));

    }
    static void StartAsAdmin(Airport airport) {
        int option;
        Scanner scanner = new Scanner(System.in);
        adminLoop : while(true) {
            airport.printInfo();
            System.out.println("Press 1 to add new plane");
            System.out.println("Press 2 to remove plane");
            System.out.println("Press 3 to add to flight");
            System.out.println("Press 4 to remove flight");
            System.out.println("Press 5 to add new employee");
            System.out.println("Press 6 to remove employee");
            System.out.println("Press 0 to back ot main menu");
            System.out.print(" : ");
            option = scanner.nextInt();
            switch(option) {
                case 1: airport.getAccess().accessControlAirplane().addNewPlane();break;
                case 2: airport.getAccess().accessControlAirplane().removePlane();break;
                case 3: airport.getAccess().accessControlAirplaneFlightTimes().addNewFlying(airport);break;
                case 4: airport.getAccess().accessControlAirplaneFlightTimes().removeFlying();break;
                case 5: airport.getAccess().accessControlAirportEmployee().addNewEmployee();break;
                case 6: airport.getAccess().accessControlAirportEmployee().removeEmployee();break;
                case 0: break adminLoop;
            }
        }
    }
    static void StartAsCustomer(Airport airport) {
        int userID;
        while(true)
        {
            String userName,password;
            Scanner scanner = new Scanner(System.in);
            System.out.println("please login");
            System.out.print("UserName : ");
            userName = scanner.next();
            System.out.print("Password : ");
            password = scanner.next();
            userID = airport.getAccess().accessControlAirportCustomer().login(userName,password);
            if(userID != -1)
                break;
            System.out.println("Wrong username or password try again");
        }
        int option;
        Scanner scanner = new Scanner(System.in);
        adminLoop : while(true) {
            airport.getAccess().accessControlAirplaneFlightTimes().showAllFlight();
            airport.getAccess().accessControlAirportCustomer().showAllCustomerFlight(userID);
            System.out.println("Press 1 take a new trip");
            System.out.println("Press 2 cancel a trip");
            System.out.println("Press 0 logout");
            System.out.print(" : ");
            option = scanner.nextInt();
            switch(option) {
                case 1: airport.getAccess().accessControlAirportCustomer().takeANewTrip(userID);break;
                case 2: airport.getAccess().accessControlAirportCustomer().cancelATrip(userID); break;
                case 0: break adminLoop;
                default:
                    System.out.println("Wrong option");
            }
        }
    }

    public static void main(String[] args) {
        Airport ammanAirport = new Airport("Queen Alia International Airport","1983/05/25");
        start(ammanAirport);
        int option;
        Scanner scanner = new Scanner(System.in);
        loop : while (true)
        {
            System.out.println("press 1 to Continue as Admin");
            System.out.println("press 2 to Continue as Customer");
            System.out.println("Press 0 to exit");
            System.out.print("  :  ");
            option =  scanner.nextInt();
            switch (option) {
                case 1 : StartAsAdmin(ammanAirport); break;
                case 2 : StartAsCustomer(ammanAirport);break;
                case 0 : break loop;
                default:
                    System.out.println("Wrong Option try other one");
            }
        }
    }
}
