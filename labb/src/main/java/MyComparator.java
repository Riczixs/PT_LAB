import java.util.Comparator;
public class MyComparator implements Comparator<Pracownik> {
    @Override
    public int compare(Pracownik p1, Pracownik p2){
        var order = Integer.compare(p1.getPoziom(),p2.getPoziom());
        if(order!=0){
            return order;
        }
        order = Integer.compare(p1.getRok_zatrudnienia(),p2.getRok_zatrudnienia());
       if(order != 0){
           return order;
       }
        order = p1.getImie().compareTo(p2.getImie());
       if(order != 0){
           return order;
       }
        return 0;
    }
}
