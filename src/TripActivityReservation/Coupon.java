package TripActivityReservation;

import TripActivityReservation.Money.Money;

public class Coupon {
    private String couponName;
    private Money discountAmount;
    private Money discountCondition;

    public void printCouponName(){
        System.out.println(this.couponName);
    }

    public boolean isUsable(Money fee){
        return discountCondition.isLessThan(fee);
    }

    public Money discount(Money fee) {
        return fee.minus(this.discountAmount);
    }
}
