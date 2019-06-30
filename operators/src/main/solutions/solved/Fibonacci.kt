package solved

import question.Progression

private class FibonacciProgression(override val start: Fibonacci, override val endInclusive: Fibonacci) : Progression<Fibonacci> {
    override fun iterator() = object : Iterator<Fibonacci> {
        private var current = start

        override fun hasNext() = current.n < endInclusive.n

        override fun next() = current.apply { current = Fibonacci(current.n + 1) }
    }
}

data class Fibonacci(val n: Int) : Comparable<Fibonacci> {
    override fun compareTo(other: Fibonacci) = n.compareTo(other.n)

    val result: Int by lazy {
        when (n) {
            0 -> 1
            1 -> 1
            else -> Fibonacci(n - 1).result + Fibonacci(n - 2).result
        }
    }

    operator fun rangeTo(end: Fibonacci): Progression<Fibonacci> = FibonacciProgression(this, end)
}
