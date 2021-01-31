package TripActivityReservation;

import TripActivityReservation.Money.Money;

import java.time.LocalDateTime;

public class Schedule {
    private LocalDateTime whenStarted;
    private Activity activity;

    public SelectedOptions selectOptions(){
        return this.activity.selectOption(this.whenStarted);
    }
}
