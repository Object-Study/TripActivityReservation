package TripActivityReservation;

import java.util.ArrayList;

public class Reservation {
    private Customer customer;
    private Schdule schdule;
    private ArrayList<Integer> selection;

    public Reservation(Customer customer, Schdule schdule, ArrayList<Integer> selection){
        this.customer = customer;
        this.schdule = schdule;
        this.selection = selection;
    }
}
