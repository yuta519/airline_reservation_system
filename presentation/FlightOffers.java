package presentation;

import java.util.Scanner;

public class FlightOffers {
    public static void search(Scanner scan) {
        System.out.println("Please input departure airport IATA code (ex: `YVR`)");
        scan.next();
        usecase.FlightOffers.show("SYD", "BKK", "2022-12-31", "2");
    }
}
