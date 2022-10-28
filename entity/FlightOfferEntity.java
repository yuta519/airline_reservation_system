package entity;

public class FlightOfferEntity {
    public String currency;
    // public Float totalPrice;
    public String totalPrice;
    public String airlineCOdes;
    public String source;
    public String ticketingBy;
    public int bookableSeats;

    public FlightOfferEntity(
        String currency,
        // Float totalPrice,
        String totalPrice,
        String airlineCOdes,
        String source,
        String ticketingBy,
        int bookableSeats
    ) {
        this.currency = currency;
        this.totalPrice = totalPrice;
        this.airlineCOdes = airlineCOdes;
        this.source = source;
        this.ticketingBy = ticketingBy;
        this.bookableSeats = bookableSeats;
    }
}
