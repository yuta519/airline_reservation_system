package presentation;

import java.util.Scanner;

public class LocationScore {
    public static void search(Scanner scan) {
        System.out.println("Please input departure airport IATA code (ex: `YVR`)");
        String deperture_code = scan.next();
        usecase.FlightOffers.show(deperture_code);
    }
}
