package Server.Domain;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class PropertyFee implements Serializable{
	private static final long serialVersionUID = 1L;
    private double amount = 50;
    private int period = 60;
    private Date feePeriodStart;
    private Date feePeriodEnd;

    public PropertyFee(){
        this.setFeePeriodStart(new Date());
        Calendar cal = Calendar.getInstance();
        cal.setTime(feePeriodStart);
        cal.add(Calendar.DAY_OF_MONTH, period);
        this.setFeePeriodEnd(cal.getTime());
    }

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getFeePeriodStart() {
		return feePeriodStart;
	}

	public void setFeePeriodStart(Date feePeriodStart) {
		this.feePeriodStart = feePeriodStart;
	}

	public Date getFeePeriodEnd() {
		return feePeriodEnd;
	}

	public void setFeePeriodEnd(Date feePeriodEnd) {
		this.feePeriodEnd = feePeriodEnd;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
		Calendar cal = Calendar.getInstance();
        cal.setTime(feePeriodStart);
        cal.add(Calendar.DAY_OF_MONTH, period);
        this.setFeePeriodEnd(cal.getTime());
	}
}