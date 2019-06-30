/**
 * Implement an Option type as a sealed class:
 *  - Option has 2 implementations: Some<X> and the object None
 *  - Add a companion object method which constructs an Option from a value of type X?
 *  - Implement orNull(), which returns the value or null
 *  - Implement map(), which takes a function: X -> Y and returns a Option<Y>
 *  - Implement flatMap(), which takes a function: X -> Option<Y> and returns a Option<Y>
 *  - Bonus* - Make Option<X> iterable
 */

sealed class Option<out X> : Iterable<X> {
    fun <NEXT> map(fn: (X) -> NEXT): Option<NEXT> = when (this) {
        is Some -> Some(fn(value))
        is None -> None
    }

    fun <NEXT> flatMap(fn: (X) -> Option<NEXT>): Option<NEXT> = when (this) {
        is Some -> fn(value)
        is None -> None
    }

    fun orNull(): X? = when (this) {
        is Some<X> -> value
        is None -> null
    }

    override fun iterator(): Iterator<X> = when (this) {
        is Some -> listOf(value)
        is None -> emptyList()
    }.iterator()

    companion object {
        operator fun <X> invoke(x: X?): Option<X> = x?.let(::Some) ?: None
    }
}

data class Some<out R>(internal val value: R) : Option<R>()

object None : Option<Nothing>()