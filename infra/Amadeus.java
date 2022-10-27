package infra;

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

    public String fetchAccessToken() {
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
            System.out.println(json);
            return json.get("access_token").textValue();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void fetchCheckIn() {
        JsonNode json = get("https://test.api.amadeus.com/v2/reference-data/urls/checkin-links?airlineCode=IB");
        System.out.println(json);
    }

    public void fetchDirectDestinations() {
        JsonNode json = get("https://test.api.amadeus.com/v1/airport/direct-destinations?departureAirportCode=BLR");
        System.out.println(json);
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
            return mapper.readTree(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
