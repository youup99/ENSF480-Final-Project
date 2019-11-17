public class Property{
    private String type;
    private int numOfBedrooms;
    private int numOfBathrooms;
    private boolean isFurnished;
    private String cityQuadrant;
    private String listingState;
    private PropertyFee fee;

    public Property(String type, int numOfBedrooms, int numOfBathrooms, boolean isFurnished, String cityQuadrant, String listingState, PropertyFee fee){
        this.type = type;
        this.numOfBedrooms = numOfBedrooms;
        this.numOfBathrooms = numOfBathrooms;
        this.isFurnished = isFurnished;
        this.cityQuadrant = cityQuadrant;
        this.listingState = listingState;
        this.fee = fee;
    }
}