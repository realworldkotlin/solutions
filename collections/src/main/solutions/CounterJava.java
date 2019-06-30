import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CounterJava implements Counter {
    public void count(Integer seed, Consumer<Integer> consumer) {
        AtomicReference<Boolean> stop = new AtomicReference<>(false);

        new Thread(() -> {
            try {
                Thread.sleep(500);
                stop.set(true);
            } catch (InterruptedException e) {
            }
        }).start();

        try {
            Stream.iterate(seed, last -> last + 1)
                .peek(i -> {
                    if (stop.get()) throw new RuntimeException();
                })
                .forEach(consumer);
        } catch (RuntimeException e) {
        }
    }
}
