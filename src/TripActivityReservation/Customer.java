package TripActivityReservation;

import TripActivityReservation.Money.Money;
import TripActivityReservation.Pay.Payment;

import java.rmi.server.RemoteServer;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private ArrayList<Coupon> coupons;

    private Money selectCoupon(Money fee){
        Scanner sc = new Scanner(System.in);
        for(Coupon each : this.coupons){
            if(each.isUsable(fee)) {
                each.printCouponName();
                if(sc.next().charAt(0) == 'y'){
                    this.coupons.remove(each);
                    return each.discount(fee);
                }
            }
        }
        return fee;
    }

    public Reservation makeaReservaion(Schedule schedule){
        SelectedOptions selectedOptions = schedule.selectOptions();
        Money fee = selectedOptions.calculateFee();
        fee = this.selectCoupon(fee);
        Payment payment = new Payment(this, fee);
        return new Reservation(this, schedule, selectedOptions, payment.requestPayment());
    }
}
