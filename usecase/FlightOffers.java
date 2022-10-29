package usecase;

import java.util.ArrayList;

import entity.FlightOfferEntity;
import repository.FlightOffersRepository;
import utils.ConsoleColors;

public class FlightOffers {
    public static void show(
        String location_code,
        String destination_code,
        String departure_date,
        String adults,
        String currency_code
    ) {
        FlightOffersRepository flight_offer_repository = new FlightOffersRepository();
        ArrayList<FlightOfferEntity> flight_offers = flight_offer_repository.fetch_flight_offers(
                                                            location_code,
                                                            destination_code,
                                                            departure_date,
                                                            adults,
                                                            currency_code
                                                        );

        flight_offers.forEach(flight_offer -> {
            System.out.printf(
                "%s Ticket Price: %s (currency %s).\n",
                ConsoleColors.GREEN,
                flight_offer.totalPrice,
                flight_offer.currency
            );
            System.out.printf(
                "%s   - Airline code: %s\n",
                ConsoleColors.GREEN,
                flight_offer.airlineCOdes
            );
            System.out.printf(
                "%s   - Information Source: %s\n",
                ConsoleColors.GREEN,
                flight_offer.source
            );
            System.out.printf(
                "%s   - Left seats: %s\n",
                ConsoleColors.GREEN,
                flight_offer.bookableSeats
            );
            System.out.printf(
                "%s   - Available Until: %s %s\n\n",
                ConsoleColors.GREEN,
                flight_offer.ticketingBy,
                ConsoleColors.RESET
            );
        });
    }
}
