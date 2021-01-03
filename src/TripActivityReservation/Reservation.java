package TripActivityReservation;

public class Reservation {
    private Customer customer;
    private Schedule schedule;
    private int numberOfCustomer;

    public Reservation(Customer customer, Schedule schedule, int numberOfCustomer){
        this.customer = customer;
        this.schedule = schedule;
        this.numberOfCustomer = numberOfCustomer;
    }
}
