package TripActivityReservation;

import java.util.ArrayList;
import java.util.List;

public class CustomersBag extends Bag {
    private List<Coupon> coupons = new ArrayList<>();

    public void addCoupon(Coupon coupon){
        this.coupons.add(coupon);
    }

    public Money getDiscountAmount(String activityType){
        Money totalDiscount = Money.ZERO;

        for(int i = 0; i < this.coupons.size(); i++) {
            totalDiscount = totalDiscount.plus(this.coupons.get(i).discount(activityType));
        }

        return totalDiscount;
    }

    public void pay(Money fee, String activityType){

        for(int i = 0; i < this.coupons.size(); i++) {
            if(this.coupons.get(i).discount(activityType) != Money.ZERO){
                this.coupons.remove(i);
                i--;
            }
        }

       minusMoney(fee);
    }

}
