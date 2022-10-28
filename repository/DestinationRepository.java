package repository;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import entity.DestinationDomain;
import infra.Amadeus;

public class DestinationRepository {
    private Amadeus amadeus;

    public DestinationRepository() {
        this.amadeus = new Amadeus();
    }

    public ArrayList<DestinationDomain> fetch_destinations(String airport) {
        ArrayNode raw_destinations = (ArrayNode) amadeus.fetchDirectDestinations(airport).get("data");
        ArrayList<DestinationDomain> destinations = new ArrayList<DestinationDomain>();

        if (raw_destinations.isArray()) {
            for (JsonNode raw_destination:raw_destinations) {
                DestinationDomain destination = new DestinationDomain(
                    raw_destination.get("type").textValue(),
                    raw_destination.get("subtype").textValue(),
                    raw_destination.get("name").textValue(),
                    raw_destination.get("iataCode").textValue()
                );
                destinations.add(destination);
            }
        }
        return destinations;
    }
}
