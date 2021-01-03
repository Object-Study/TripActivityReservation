package TripActivityReservation;

public class Coupon {
    private String couponType;
    private Money discountAmount;

    public Coupon(String couponType, Money discountAmount){
        this.couponType = couponType;
        this.discountAmount = discountAmount;
    }

    public Money discount(String ActivityType) {
        if(this.couponType == ActivityType){
            return discountAmount;
        }
        return Money.ZERO;
    }

}
