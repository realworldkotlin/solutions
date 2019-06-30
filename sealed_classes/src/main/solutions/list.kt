/**
 * Implement a RwkList type as a sealed class:
 *  - Try has 2 implementations: Empty and NonEmpty<X> - which consists of a head X and a tail RwkList<X> .
 *  - Add a companion object method which takes a variable number of X and returns RwkList<X>
 *  - Implement map(), which takes a function: X -> Y and returns a RwkList<Y>
 *  - Implement recursive extension operator function plus(), which takes 2 RwkList<Y>s and returns a RwkList<Y>
 *  - Implement recursive flatMap() using + which takes a function: X -> RwkList<Y> and returns a RwkList<Y>
 *  - Implement recursive foldRight(), which takes a acc Y and a combiner function: (Y, X) -> Y and returns a Y
 *  - Bonus* - Make RwkList<X> iterable - you will need to create a custom iterator with a field to track the current state
 */

sealed class RwkList<out X> : Iterable<X> {
    fun <Y> map(fn: (X) -> Y): RwkList<Y> = when (this) {
        is Empty -> Empty
        is NonEmpty -> NonEmpty(fn(head), tail.map(fn))
    }

    fun <Y> flatMap(fn: (X) -> RwkList<Y>): RwkList<Y> = when (this) {
        is Empty -> Empty
        is NonEmpty<X> -> fn(head) + tail.flatMap(fn)
    }

    fun <ACC> foldRight(memo: ACC, fn: (X, ACC) -> ACC): ACC = when (this) {
        is Empty -> memo
        is NonEmpty -> fn(head, tail.foldRight(memo, fn))
    }

    override fun iterator(): Iterator<X> = when (this) {
        is Empty -> emptyList<X>().iterator()
        is NonEmpty<X> -> object : Iterator<X> {
            private var ref: RwkList<X> = this@RwkList

            override fun hasNext(): Boolean = when (ref) {
                is NonEmpty -> true
                is Empty -> false
            }

            override fun next(): X = ref.run {
                when (this) {
                    is NonEmpty -> {
                        ref = tail
                        head
                    }
                    else -> throw IndexOutOfBoundsException()
                }
            }
        }
    }

    companion object {
        operator fun <X> invoke(vararg values: X): RwkList<X> = when {
            values.isEmpty() -> Empty
            else -> NonEmpty(values[0], RwkList(*values.sliceArray(1 until values.size)))
        }
    }
}

operator fun <Y> RwkList<Y>.plus(next: RwkList<Y>): RwkList<Y> = when (this) {
    is Empty -> next
    is NonEmpty -> NonEmpty(head, tail + next)
}

data class NonEmpty<out R>(val head: R, val tail: RwkList<R>) : RwkList<R>()

object Empty : RwkList<Nothing>()


fun main(args: Array<String>) {
    println(RwkList(1, 2, 3) + RwkList(4, 5, 6))
    println(RwkList(1, 2, 3).flatMap { RwkList(it, it) })
}