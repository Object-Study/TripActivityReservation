package TripActivityReservation;

import java.time.LocalDateTime;
import java.time.Duration;

public class RefundPolicy {
    private int refundAvailableDays;

    public boolean refundable(LocalDateTime whenStarted){
        LocalDateTime now = LocalDateTime.now();
        Duration duration =  Duration.between(now, whenStarted);
        return duration.toDays() >= this.refundAvailableDays;
    }
}
