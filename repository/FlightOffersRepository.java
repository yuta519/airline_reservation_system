package repository;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import entity.FlightOfferEntity;
import infra.Amadeus;

public class FlightOffersRepository {
    private Amadeus amadeus;

    public FlightOffersRepository() {
        this.amadeus = new Amadeus();
    }

    public ArrayList<FlightOfferEntity> fetch_flight_offers(
        String location_code,
        String destination_code,
        String departure_date,
        String adults,
        String currency_code
    ) {
        ArrayNode raw_flight_offers = (ArrayNode) amadeus.fetch_flight_offers(
                                                location_code,
                                                destination_code,
                                                departure_date,
                                                adults,
                                                currency_code
                                            ).get("data");

        ArrayList<FlightOfferEntity> flight_offers = new ArrayList<FlightOfferEntity>();

        if (!raw_flight_offers.isArray()) return flight_offers;

        for (JsonNode raw_flight:raw_flight_offers) {
            FlightOfferEntity flight_offer = new FlightOfferEntity(
                raw_flight.get("price").get("currency").textValue(),
                raw_flight.get("price").get("total").textValue(),
                "aa",
                raw_flight.get("source").textValue(),
                raw_flight.get("lastTicketingDate").textValue(),
                raw_flight.get("numberOfBookableSeats").intValue()
            );
            flight_offers.add(flight_offer);
        }
        return flight_offers;
    }


}
