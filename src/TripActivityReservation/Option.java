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

    public Money calculateFee(int userCount){
        return this.Fee.times(userCount).times(1-discountRate);
    }
}