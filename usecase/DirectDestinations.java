package usecase;

import java.util.ArrayList;

import entity.DestinationEntity;
import repository.DestinationRepository;
import utils.ConsoleColors;

public class DirectDestinations {
    public static void show(String airport) {
        DestinationRepository destination_repository = new DestinationRepository();
        ArrayList<DestinationEntity> destinations = destination_repository.fetch_destinations(airport);
        destinations.forEach(destination -> {
            System.out.println(
                ConsoleColors.GREEN + destination.name +
                "(IATA Code:" +  destination.iataCode + ")"
                +ConsoleColors.RESET
            );
        });
    }
}
