package infra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Amadeus {
    private String API_KEY;
    private String API_SECRET;
    private String TOKEN;

    public Amadeus() {
        this.API_KEY = System.getenv("API_KEY");
        this.API_SECRET = System.getenv("API_SECRET");
        this.TOKEN = fetchAccessToken();
    }

    private String fetchAccessToken() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://test.api.amadeus.com/v1/security/oauth2/token"))
            .timeout(Duration.ofSeconds(60))
            .header("Content-Type", "application/x-www-form-urlencoded")
            .POST(BodyPublishers.ofString(
                "grant_type=client_credentials&client_id="+this.API_KEY+"&client_secret="+this.API_SECRET
            ))
            .build();

        try {
            HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
            );

            ObjectMapper mapper = new ObjectMapper();
            JsonNode json= mapper.readTree(response.body());
            return json.get("access_token").textValue();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }

    private JsonNode get(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .timeout(Duration.ofSeconds(60))
            .header("Authorization", "Bearer " + this.TOKEN)
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            // System.out.println(response.statusCode());
            return mapper.readTree(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void fetchCheckIn() {
        JsonNode json = get("https://test.api.amadeus.com/v2/reference-data/urls/checkin-links?airlineCode=IB");
        System.out.println(json);
    }

    public JsonNode fetch_direct_destinations(String airport) {
        return get("https://test.api.amadeus.com/v1/airport/direct-destinations?departureAirportCode="+airport);
    }

    public JsonNode fetch_locations(String keyword) {
        return get("https://test.api.amadeus.com/v1/reference-data/locations?subType=CITY,AIRPORT&keyword="+keyword);
    }

    public JsonNode fetch_flight_offers(
        String location_code, String destination_code, String departure_date, String adults, String currency_code
    ) {
        return get(
            "https://test.api.amadeus.com/v2/shopping/flight-offers?"+
            "originLocationCode="+location_code+
            "&destinationLocationCode="+destination_code+
            "&departureDate="+departure_date+
            "&adults="+adults+"&currencyCode="+currency_code+"&max=10"
        );
    }

    public void fetch_location_score() {
		File file = new File("location_to_long-lati.csv");
        try {
			if (file.exists()) {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String content;
				while ((content = br.readLine()) != null) {
					System.out.println(content);
				}
				br.close();
			}
            // "https://test.api.amadeus.com/v1/location/analytics/category-rated-areas?latitude=41.397158&longitude=2.160873"
		} catch (IOException ex) {
			ex.printStackTrace();
		}
    }
}
