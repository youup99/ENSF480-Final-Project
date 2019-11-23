package Client;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class SummaryReport implements Serializable{
	private static final long serialVersionUID = 1L;
    private Date startDate;
    private Date endDate;
    private int totalListed;
    private int totalRented;
    private int totalActive;
    private ArrayList<Property> housesRented;

    public SummaryReport(){

    }
    
}
