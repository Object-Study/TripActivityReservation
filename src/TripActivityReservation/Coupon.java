package TripActivityReservation;

import TripActivityReservation.Money.Money;

public class Coupon {
    private Money discountAmount;

    public boolean isUsable(){
        return true;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }
}
