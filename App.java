
import infra.Amadeus;

public class App {
    public static void main(String[] args) {
        Amadeus amadeus = new Amadeus();
        System.out.println("############################");
        amadeus.fetchDirectDestinations();
    }
}
