package Server.Domain;

import java.util.Random;

public class Property {
	private int ID;
	private String type;
	private int numOfBedrooms;
	private int numOfBathrooms;
	private boolean isFurnished;
	private String cityQuadrant;
	private String listingState;
	private PropertyFee fee;

	public Property(String type, int numOfBedrooms, int numOfBathrooms, boolean isFurnished, String cityQuadrant,
			String listingState) {
		this.ID = new Random().nextInt(1000000);
		this.setType(type);
		this.setNumOfBedrooms(numOfBedrooms);
		this.setNumOfBathrooms(numOfBathrooms);
		this.setFurnished(isFurnished);
		this.setCityQuadrant(cityQuadrant);
		this.setListingState(listingState);
		this.fee = new PropertyFee();
	}

	public Property(int ID, String type, int numOfBedrooms, int numOfBathrooms, boolean isFurnished, String cityQuadrant,
			String listingState) {
		this.ID = ID;
		this.setType(type);
		this.setNumOfBedrooms(numOfBedrooms);
		this.setNumOfBathrooms(numOfBathrooms);
		this.setFurnished(isFurnished);
		this.setCityQuadrant(cityQuadrant);
		this.setListingState(listingState);
		this.fee = new PropertyFee();
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

}