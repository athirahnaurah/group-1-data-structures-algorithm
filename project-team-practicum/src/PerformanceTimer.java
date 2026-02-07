import java.util.function.Supplier;

public class PerformanceTimer {

    public static long calculate(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        return end - start; // nanoseconds
    }

    public static <T> TimeResult<T> calculateWithResult(Supplier<T> task) {
        long start = System.nanoTime();
        T result = task.get();
        long end = System.nanoTime();

        return new TimeResult<>(result, end - start);
    }
}
