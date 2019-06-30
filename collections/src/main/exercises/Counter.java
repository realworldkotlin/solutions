import java.util.function.Consumer;

/**
 * Using a lazy sequence, implement a counter which:
 * - Counts upwards starting with the seed value, applying the consumer function to each value in the stream.
 * - Starts a thread which terminates the stream after 500ms.
 */
public interface Counter {
    void count(Integer seed, Consumer<Integer> consumer);
}

