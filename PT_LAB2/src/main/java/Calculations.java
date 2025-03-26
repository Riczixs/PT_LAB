//import java.util.*;
//import java.util.concurrent.LinkedBlockingQueue;
//
//public class Calculations implements Runnable {
//    private final DataSource data;
//    private final Result result;
//    private Integer sum;
//    public Calculations(DataSource dataSource, Result result) {
//        this.data = dataSource;
//        this.result = result;
//        this.sum = 0;
//    }
//
//    @Override
//    public void run() {
//        while(!Thread.interrupted()){
//        //OBSŁUGA WYDZIELENIA ZADANIA DLA WĄTKU
//            LinkedBlockingQueue<Integer> temp = data.getData();
//
//            if(temp != null){
//                for (Integer i : temp) {
//                    this.sum += i;
//                }
//            }
//            result.addResult(sum);
//            sum = 0;
//            System.out.println("Watek pracuje!");
//        }
//    }
//
//
//}
