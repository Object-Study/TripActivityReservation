package TripActivityReservation;

import TripActivityReservation.Money.Money;

import java.util.HashMap;
import java.util.Map;

public class SelectedOptions {
    private Map<Option, Integer> hashMap = new HashMap<Option, Integer>();

    public void addTo(Option key, int value){
        this.hashMap.put(key, value);
    }

    public Money calculateFee(){
        Money fee = Money.ZERO;
        for(Map.Entry<Option, Integer> entry: hashMap.entrySet()){
            fee = fee.plus(entry.getKey().calculateFee(entry.getValue()));
        }
        return fee;
    }
}
