import java.util.concurrent.Callable;

public class Calc implements Callable<Integer> {
    private final int start;
    private final int end;

    public Calc(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        return PrimeFib(start, end);
    }

    public int PrimeFib(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isFibonacci(i) && isPrime(i)) {
                count++;
                System.out.println(i);
            }
        }
        return count;
    }

    public boolean isFibonacci(int x) {
        if (x == 1) return true;
        int fib_1 = 1, fib_2 = 1, res = 0;
        while (res < x) {
            res = fib_1 + fib_2;
            fib_1 = fib_2;
            fib_2 = res;
        }
        return x == res;
    }

    public boolean isPrime(int x) {
        if (x <= 1) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
