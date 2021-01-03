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

    public Money getTotalFee(Bag bag, int numberOfCustomer) {
        Money totalFee = this.fee.times(numberOfCustomer).minus(bag.getDiscountAmount(this.activityType));
        return totalFee;
    }

    public void receivePayment(Bag bag, int numberOfCustomer){
        Money totalFee = getTotalFee(bag, numberOfCustomer);
        bag.pay(totalFee, this.activityType);
        this.provider.getPaid(totalFee.times(0.5));
    }
}
