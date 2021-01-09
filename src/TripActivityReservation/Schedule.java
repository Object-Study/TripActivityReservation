package TripActivityReservation;

import java.time.LocalDateTime;

public class Schedule {
    private Activity activity;
    private LocalDateTime whenStarted;
    private RefundPolicy refundPolicy;
    private static int maxCustomer;
    private int totalNumberOfCustomer;

    public Schedule(Activity activity, LocalDateTime whenStarted, RefundPolicy refundPolicy, int maxCustomer){
        this.activity = activity;
        this.whenStarted = whenStarted;
        this.refundPolicy = refundPolicy;
        this.maxCustomer = maxCustomer;
        this.totalNumberOfCustomer = 0;
    }

    public boolean addable(int numberOfCustomer){
        return this.maxCustomer >= this.totalNumberOfCustomer + numberOfCustomer;
    }

    public Money calculateTotalFee(CustomersBag bag, int numberOfCustomer){
        Money totalFee = this.activity.getTotalFee(bag, numberOfCustomer);
        return totalFee;
    }

    public Money progressPayment(CustomersBag bag, int numberOfCustomer){
        return this.activity.receivePayment(bag, numberOfCustomer);
    }

    public boolean progressRefunding(Money totalFee) {
        if(refundPolicy.refundable(whenStarted)){
            activity.cancelled(totalFee);
            return true;
        }
        return false;
    }
}
