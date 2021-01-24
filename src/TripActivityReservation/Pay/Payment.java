package TripActivityReservation.Pay;

import TripActivityReservation.Customer;
import TripActivityReservation.Money.Money;

public class Payment {
    private Customer customer;
    private Money fee;

    public Payment(Customer customer, Money fee){
        this.customer = customer;
        this.fee = fee;
    }
    public boolean requestPayment(){
        return true;
    }
}
