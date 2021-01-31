package TripActivityReservation;

import TripActivityReservation.Money.Money;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Activity {
    private ArrayList<Option> options = new ArrayList<>();

    public SelectedOptions selectOption(LocalDateTime whenStarted){
        SelectedOptions selectedOptions = new SelectedOptions();
        Scanner sc = new Scanner(System.in);
        for(Option each : this.options){
            if(each.isSelectable(whenStarted)) {
                each.printOptionName();
                selectedOptions.addTo(each, Integer.parseInt(sc.next()));
            }
            else{
                selectedOptions.addTo(each, 0);
            }
        }
        return selectedOptions;
    }

    public Money calculateFee(ArrayList<Integer> selection){
        Money totalFee = Money.ZERO;
        for(int i = 0; i < selection.size(); i++){
            totalFee.plus(this.options.get(i).calculateFee(selection.get(i)));
        }
        return totalFee;
    }
}
