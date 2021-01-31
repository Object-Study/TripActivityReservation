package TripActivityReservation;

import TripActivityReservation.Pay.Payment;

import java.util.ArrayList;

public class Reservation {
    private Customer customer;
    private Schedule schedule;
    private SelectedOptions selectedOption;
    private boolean isConfirmed;

    public Reservation(Customer customer, Schedule schedule, SelectedOptions selectedOptions, boolean isConfirmed){
        this.customer = customer;
        this.schedule = schedule;
        this.selectedOption = selectedOptions;
        this.isConfirmed = isConfirmed;
    }
}
