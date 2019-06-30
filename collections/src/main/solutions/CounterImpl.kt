
import java.util.concurrent.atomic.AtomicReference
import java.util.function.Consumer
import kotlin.concurrent.thread

class CounterImpl : Counter {
    override fun count(seed: Int, consumer: Consumer<Int>) {
        val stop = AtomicReference(false)
        thread {
            Thread.sleep(100)
            stop.set(true)
        }

        generateSequence(seed) { if (stop.get()) null else it + 1 }
            .forEach(consumer::accept)
    }
}