package TripActivityReservation;

public class Bag {
    private Money money;

    public Bag(Money money){
        this.money = money;
    }

    public Bag(){
        this.money = Money.ZERO;
    }

    public void plusMoney(Money amount){
        this.money = this.money.plus(amount);
    }

    public boolean payable(Money fee){
        return this.money.isGreaterThanOrEqual(fee);
    }

    public void minusMoney(Money amount){
        this.money = this.money.minus(amount);
    }

}
