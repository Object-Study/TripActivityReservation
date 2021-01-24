package TripActivityReservation;

import TripActivityReservation.Money.Money;

import java.time.LocalDateTime;


public class Option {
    private String name;
    private Money Fee;
    private double discountRate;

    public void printOptionName(){
        System.out.print(this.name);
    }

    public boolean isSelectable(LocalDateTime whenStarted){
        return true;
    }

    public Money calculateFee(int numberOfCustomer){
        return this.Fee.times(numberOfCustomer).times(1-discountRate);
    }
}