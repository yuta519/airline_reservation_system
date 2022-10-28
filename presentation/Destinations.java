package presentation;

import java.util.Scanner;

import usecase.DirectDestinations;

public class Destinations {
    public static void search(Scanner scan) {
        System.out.println("Please input departure airport IATA code (ex: `YVR`)");
        DirectDestinations.show(scan.next());
    }
}
