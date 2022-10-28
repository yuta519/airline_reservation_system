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
        String adults
    ) {
        FlightOffersRepository flight_offer_repository = new FlightOffersRepository();
        ArrayList<FlightOfferEntity> flight_offers = flight_offer_repository.fetch_flight_offers(
                                                            location_code,
                                                            destination_code,
                                                            departure_date,
                                                            adults
                                                        );

        flight_offers.forEach(flight_offer -> {
            System.out.printf(
                "%s Ticket Price: %s (currency %s). %s\n",
                ConsoleColors.GREEN,
                flight_offer.totalPrice,
                flight_offer.currency,
                ConsoleColors.RESET
            );
        });
    }
}
