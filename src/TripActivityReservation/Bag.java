package TripActivityReservation;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Coupon> coupons = new ArrayList<>();
    private Money money;

    public Bag(Money money){
        this.money = money;
    }

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

    public boolean payable(Money fee){
        return this.money.isGreaterThanOrEqual(fee);
    }

    public void pay(Money fee, String activityType){

        for(int i = 0; i < this.coupons.size(); i++) {
            if(this.coupons.get(i).discount(activityType) != Money.ZERO){
                this.coupons.remove(i);
                i--;
            }
        }

        this.money = this.money.minus(fee);
    }

    public void getMoney(Money amount){
        this.money = this.money.plus(amount);
    }

}
