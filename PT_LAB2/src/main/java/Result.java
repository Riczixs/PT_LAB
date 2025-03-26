import java.util.concurrent.CopyOnWriteArrayList;

public class Result {
    private int results;

    public Result() {
        this.results =0;
    }
    public synchronized void addResult(int res){
        results+=res;
    }

    public void printResult(){
        System.out.println("Liczba znalezionych liczb pierwszych fibonacciego: " + results);
    }

}
