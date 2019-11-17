import java.util.Date;

public class PropertyFee{
    private int amount;
    private Date feePeriodStart;
    private Date feePeriodEnd;

    public PropertyFee(int amount, Date feePeriodStart, Date feePeriodEnd){
        this.amount = amount;
        this.feePeriodStart = new Date();
        this.feePeriodEnd = new Date(); // TODO: add 60 days 
    }
}