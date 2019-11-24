package Server.Domain;

import java.io.Serializable;
import java.util.Random;

public class Property implements Serializable{
	private static final long serialVersionUID = 1L;
	private int ID;
	private String address;
	private String type;
	private int numOfBedrooms;
	private int numOfBathrooms;
	private boolean isFurnished;
	private String cityQuadrant;
	private String listingState = "Active";
	private PropertyFee fee;
	private String landlordName;

	public Property(String address, String type, int numOfBedrooms, int numOfBathrooms, boolean isFurnished, String cityQuadrant, String landlordName) {
		this.ID = new Random().nextInt(1000000);
		this.setAddress(address);
		this.setType(type);
		this.setNumOfBedrooms(numOfBedrooms);
		this.setNumOfBathrooms(numOfBathrooms);
		this.setFurnished(isFurnished);
		this.setCityQuadrant(cityQuadrant);
		this.fee = new PropertyFee();
		this.setLandlordName(landlordName);
	}

	public Property(int ID, String address, String type, int numOfBedrooms, int numOfBathrooms, boolean isFurnished, String cityQuadrant, String listingState, String landlordName) {
		this.ID = ID;
		this.setAddress(address);
		this.setType(type);
		this.setNumOfBedrooms(numOfBedrooms);
		this.setNumOfBathrooms(numOfBathrooms);
		this.setFurnished(isFurnished);
		this.setCityQuadrant(cityQuadrant);
		this.setListingState(listingState);
		this.fee = new PropertyFee();
		this.setLandlordName(landlordName);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumOfBedrooms() {
		return numOfBedrooms;
	}

	public void setNumOfBedrooms(int numOfBedrooms) {
		this.numOfBedrooms = numOfBedrooms;
	}

	public int getNumOfBathrooms() {
		return numOfBathrooms;
	}

	public void setNumOfBathrooms(int numOfBathrooms) {
		this.numOfBathrooms = numOfBathrooms;
	}

	public boolean isFurnished() {
		return isFurnished;
	}

	public void setFurnished(boolean isFurnished) {
		this.isFurnished = isFurnished;
	}

	public String getCityQuadrant() {
		return cityQuadrant;
	}

	public void setCityQuadrant(String cityQuadrant) {
		this.cityQuadrant = cityQuadrant;
	}

	public String getListingState() {
		return listingState;
	}

	public void setListingState(String listingState) {
		this.listingState = listingState;
	}

	public PropertyFee getFee() {
		return fee;
	}

	public void setFee(PropertyFee fee) {
		this.fee = fee;
	}

	public int getID() {
		return ID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getLandlordName() {
		return landlordName;
	}

	public void setLandlordName(String landlordName) {
		this.landlordName = landlordName;
	}

}