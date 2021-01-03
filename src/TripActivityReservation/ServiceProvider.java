package TripActivityReservation;

public class ServiceProvider {
    private String id;
    private String name;
    private Bag bag;

    public ServiceProvider(String id, String name, Bag bag){
        this.id = id;
        this.name = name;
        this.bag = bag;
    }

    public void getPaid(Money paidAmount){
        this.bag.getMoney(paidAmount);
    }

}
