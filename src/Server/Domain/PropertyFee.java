package Server.Domain;
import java.util.Calendar;
import java.util.Date;

public class PropertyFee{
    private double amount = 50;
    private Date feePeriodStart;
    private Date feePeriodEnd;

    public PropertyFee(){
        this.setFeePeriodStart(new Date());
        Calendar cal = Calendar.getInstance();
        cal.setTime(feePeriodStart);
        cal.add(Calendar.DAY_OF_MONTH, 60);
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
}