package TripActivityReservation;

public class Customer {
    private String id;
    private String name;
    private Bag bag;

    public Customer(String id, String name, Bag bag){
        this.id = id;
        this.name = name;
        this.bag = bag;
    }

    public void getCoupon(Coupon coupon){
        this.bag.addCoupon(coupon);
    }

    public void Reserve(Schedule schedule, int numberOfCustomer){
        if(schedule.addable(numberOfCustomer) && bag.payable(schedule.calculateTotalFee(bag, numberOfCustomer))){
            schedule.progressPayment(bag, numberOfCustomer);
            Reservation reservation = new Reservation(this, schedule, numberOfCustomer);
        }
    }
}
