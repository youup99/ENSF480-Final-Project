package Server.Domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;

public class SummaryReport implements Serializable{
	private static final long serialVersionUID = 1L;
    private Date startDate;
    private Date endDate;
    private int totalListed;
    private int totalRented;
    private int totalActive;
    private ArrayList<Property> housesRented;

    public SummaryReport(Date startDate, Date endDate, int totalListed, int totalRented, int totalActive, ArrayList<Property> housesRented){
    	this.setStartDate(startDate);
    	this.setEndDate(endDate);
    	this.setTotalListed(totalListed);
    	this.setTotalRented(totalRented);
    	this.setTotalActive(totalActive);
    	this.setHousesRented(housesRented);
    }

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getTotalListed() {
		return totalListed;
	}

	public void setTotalListed(int totalListed) {
		this.totalListed = totalListed;
	}

	public int getTotalRented() {
		return totalRented;
	}

	public void setTotalRented(int totalRented) {
		this.totalRented = totalRented;
	}

	public int getTotalActive() {
		return totalActive;
	}

	public void setTotalActive(int totalActive) {
		this.totalActive = totalActive;
	}

	public ArrayList<Property> getHousesRented() {
		return housesRented;
	}

	public void setHousesRented(ArrayList<Property> housesRented) {
		this.housesRented = housesRented;
	}
    
}