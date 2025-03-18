package org.example;
import java.util.Comparator;
public class AlternativeComparator implements Comparator<Mage>{
    @Override
    public int compare(Mage o1, Mage o2) {
        var order = Integer.compare(o1.getLevel(), o2.getLevel());
        if(order != 0){
            return order;
        }
        return 0;
    }
}
