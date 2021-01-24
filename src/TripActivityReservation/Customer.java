package TripActivityReservation;

import TripActivityReservation.Money.Money;
import TripActivityReservation.Pay.Payment;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Coupon> coupons = new ArrayList<>();

    public boolean pay(Money fee){
        fee.minus(this.useCoupon());
        Payment payment =  new Payment(this, fee);
        return payment.requestPayment();
    }

    private Money useCoupon(){
        for(Coupon each:coupons){
            if(each.isUsable()){
                //선택지 띄우기
                //선택 후 getDiscountAmount 하여 계산
            }
        }
        return Money.ZERO;
    }
}
