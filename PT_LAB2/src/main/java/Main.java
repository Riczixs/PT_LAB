import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2); // Tworzymy 2 wątki
        Result results = new Result();

        // Tworzenie zadań
        Calc task1 = new Calc(0, 500000000);
        Calc task2 = new Calc(500000001, 1000000000);

        // Uruchamianie wątków i pobieranie `Future<Integer>`
        Future<Integer> future1 = executor.submit(task1);
        Future<Integer> future2 = executor.submit(task2);

        executor.shutdown(); // Zamykamy pulę wątków

        try {
            // Pobranie wyników
            int res1 = future1.get();
            int res2 = future2.get();

            // Dodanie wyników do obiektu Result
            results.addResult(res1);
            results.addResult(res2);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        results.printResult(); // Wyświetlenie wyniku końcowego
    }
}
