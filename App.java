import repository.DestinationRepository;

import java.util.ArrayList;

import entity.DestinationDomain;
import presentation.StdIn;

public class App {
    public static void main(String[] args) {
        StdIn.decideService();
        DestinationRepository destination_repository = new DestinationRepository();
        ArrayList<DestinationDomain> destinations = destination_repository.fetch_destinations("YVR");

        destinations.forEach(destination -> System.out.println(destination.name));
    }
}
