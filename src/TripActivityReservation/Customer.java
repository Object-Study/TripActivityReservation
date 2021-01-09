package TripActivityReservation;

public class Customer {
    private String id;
    private String name;
    private CustomersBag bag;

    public Customer(String id, String name, CustomersBag bag){
        this.id = id;
        this.name = name;
        this.bag = bag;
    }

    public void getCoupon(Coupon coupon){

        this.bag.addCoupon(coupon);
    }

    public void Reserve(Schedule schedule, int numberOfCustomer){
        if(schedule.addable(numberOfCustomer) && bag.payable(schedule.calculateTotalFee(bag, numberOfCustomer))){
            Reservation reservation = new Reservation(this, schedule, numberOfCustomer, schedule.progressPayment(bag, numberOfCustomer));
        }
    }

    public void refund(Reservation reservation){
        this.bag.plusMoney(reservation.requestedRefunding());
    }
}
