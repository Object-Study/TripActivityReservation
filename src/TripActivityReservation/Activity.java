package TripActivityReservation;

import java.time.Duration;

public class Activity {
    private String title;
    private Duration estimatedTime;
    private Money fee;
    private String activityType;
    private ServiceProvider provider;

    public Activity(String title, Duration estimatedTime, Money fee, String activityType, ServiceProvider provider){
        this.title = title;
        this.estimatedTime = estimatedTime;
        this.fee = fee;
        this.activityType = activityType;
        this.provider = provider;
    }

    public Money getTotalFee(CustomersBag bag, int numberOfCustomer) {
        Money totalFee = this.fee.times(numberOfCustomer).minus(bag.getDiscountAmount(this.activityType));
        return totalFee;
    }

    public Money receivePayment(CustomersBag bag, int numberOfCustomer){
        Money totalFee = getTotalFee(bag, numberOfCustomer);
        bag.pay(totalFee, this.activityType);
        this.provider.getPaid(totalFee.times(0.5));
        return totalFee;
    }

    public void cancelled(Money totalFee){
        this.provider.losePaid(totalFee.times(0.5));
    }
}
