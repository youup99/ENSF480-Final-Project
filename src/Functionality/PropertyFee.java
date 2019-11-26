package Functionality;
import java.io.Serializable;
import java.util.Calendar;
import java.sql.Date;

public class PropertyFee implements Serializable{
	private static final long serialVersionUID = 1L;
    private double amount = 50;
    private int period = 60;
    private String feePeriodStart;
    private String feePeriodEnd;

    public PropertyFee(){
        this.setFeePeriodStart(new Date(Calendar.getInstance().getTimeInMillis()).toString());
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(Calendar.getInstance().getTimeInMillis()));;
        cal.add(Calendar.DAY_OF_MONTH, period);
        this.setFeePeriodEnd(new Date(cal.getTimeInMillis()).toString());
    }

    public PropertyFee(String feePeriodStart, String feePeriodEnd) {
    	this.setFeePeriodStart(feePeriodStart);
    	this.setFeePeriodEnd(feePeriodEnd);
    }
    
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getFeePeriodStart() {
		return feePeriodStart;
	}

	public void setFeePeriodStart(String feePeriodStart) {
		this.feePeriodStart = feePeriodStart;
	}

	public String getFeePeriodEnd() {
		return feePeriodEnd;
	}

	public void setFeePeriodEnd(String date) {
		this.feePeriodEnd = date;
	}

	public int getPeriod() {
		return period;
	}

	@SuppressWarnings("deprecation")
	public void setPeriod(int period) {
		this.period = period;
		Calendar cal = Calendar.getInstance();
        //cal.setTime(new java.util.Date(feePeriodStart));
        cal.add(Calendar.DAY_OF_MONTH, period);
        this.setFeePeriodEnd(new Date(cal.getTimeInMillis()).toString());
	}
}