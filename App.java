import repository.DestinationRepository;
import presentation.StdIn;

public class App {
    public static void main(String[] args) {
        StdIn.decideService();
        DestinationRepository destination_repository = new DestinationRepository();
        destination_repository.fetch_destinations("YVR");
    }
}
