package TripActivityReservation;

public class Reservation {
    private Customer customer;
    private Schedule schedule;
    private int numberOfCustomer;
    private Money totalFee;
    private boolean isCancelled;

    public Reservation(Customer customer, Schedule schedule, int numberOfCustomer, Money totalFee){
        this.customer = customer;
        this.schedule = schedule;
        this.numberOfCustomer = numberOfCustomer;
        this.totalFee = totalFee;
        this.isCancelled = false;
    }

    public Money requestedRefunding(){
        if(this.schedule.progressRefunding(this.totalFee)){
            isCancelled = true;
            return totalFee;
        }
        else{
            return Money.ZERO;
        }
    }
}
