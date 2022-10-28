package repository;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import entity.DestinationEntity;
import infra.Amadeus;

public class DestinationRepository {
    private Amadeus amadeus;

    public DestinationRepository() {
        this.amadeus = new Amadeus();
    }

    public ArrayList<DestinationEntity> fetch_destinations(String airport) {
        ArrayNode raw_destinations = (ArrayNode) amadeus
                                        .fetch_direct_destinations(airport)
                                        .get("data");

        ArrayList<DestinationEntity> destinations = new ArrayList<DestinationEntity>();

        if (!raw_destinations.isArray()) return destinations;

        for (JsonNode raw_destination : raw_destinations) {
            DestinationEntity destination = new DestinationEntity(
                raw_destination.get("type").textValue(),
                raw_destination.get("subtype").textValue(),
                raw_destination.get("name").textValue(),
                raw_destination.get("iataCode").textValue()
            );
            destinations.add(destination);
        }
        return destinations;
    }
}
