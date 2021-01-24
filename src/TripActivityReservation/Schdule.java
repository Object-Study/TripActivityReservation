package TripActivityReservation;



import java.time.LocalDateTime;
import java.util.ArrayList;

public class Schdule {
    private Activity activity;
    private LocalDateTime whenStarted;

    public Reservation reserve(Customer customer){
        ArrayList<Integer> selection = this.activity.selectOption(this.whenStarted);
        if(customer.pay(this.activity.calculateFee(selection))) {
            return new Reservation(customer, this, selection);
        }
        return null;
    }
}
