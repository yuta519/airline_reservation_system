package domain;

public class DestinationDomain {
    public String type;
    public String subType;
    public String name;
    public String iataCode;

    public DestinationDomain(String type, String subType, String name, String iataCode) {
        this.type = type;
        this.subType = subType;
        this.name = name;
        this.iataCode = iataCode;
    }
}
