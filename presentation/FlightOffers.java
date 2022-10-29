package presentation;

import java.util.Scanner;

public class FlightOffers {
    public static void search(Scanner scan) {
        System.out.println("Please input departure airport IATA code (ex: `YVR`)");
        String deperture_code = scan.next();
        System.out.println("Please input destination airport IATA code (ex: `YVR`)");
        String destination_code = scan.next();
        System.out.println("Please input departure date. The format is yyyy-mm-dd like `2022-12-31`");
        String deperture_date = scan.next();
        System.out.println("Please input number of adults.");
        String adults = scan.next();
        System.out.println("Please input currency code like `CAD`");
        String currency_code = scan.next();
        usecase.FlightOffers.show(deperture_code, destination_code, deperture_date, adults, currency_code);
    }
}
