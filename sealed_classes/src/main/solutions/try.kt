/**
 * Implement a Try type as a sealed class:
 *  - Try has 2 implementations: Success<X> and Failure<Nothing>
 *  - Add a companion object method which constructs an Try from a block which could succeed OR could throw an exception
 *  - Implement orThrow(), which returns the successful value or throws the exception
 *  - Implement map(), which takes a function: X -> Y and returns a Try<Y>
 *  - Implement flatMap(), which takes a function: X -> Try<Y> and returns a Try<Y>
 *  - Implement mapError(), which takes a function: Exception -> X and returns a Try<X>
 *  - Implement flatMapError(), which takes a function: Exception -> Try<X> and returns a Try<X>
 *  - Bonus* - Make Try<X> iterable
 */

sealed class Try<X> : Iterable<X> {
    fun <NEXT> map(fn: (X) -> NEXT): Try<NEXT> = when (this) {
        is Success -> Success(fn(value))
        is Failure -> Failure(value)
    }

    fun mapError(fn: (Exception) -> X): Try<X> = when (this) {
        is Success -> Success(value)
        is Failure -> Success(fn(value))
    }

    fun <NEXT> flatMap(fn: (X) -> Try<NEXT>): Try<NEXT> = when (this) {
        is Success -> fn(value)
        is Failure -> Failure(value)
    }

    fun flatMapError(fn: (Exception) -> Try<X>): Try<X> = when (this) {
        is Success -> this
        is Failure -> fn(value)
    }

    fun orThrow(): X = when (this) {
        is Success -> value
        is Failure -> throw value
    }

    override fun iterator(): Iterator<X> = when (this) {
        is Success<X> -> listOf(value)
        is Failure -> emptyList()
    }.iterator()

    companion object {
        operator fun <X> invoke(fn: () -> X): Try<X> = try {
            Success(fn())
        } catch (e: Exception) {
            Failure(e)
        }
    }
}

data class Success<R>(internal val value: R) : Try<R>()
data class Failure<R>(internal val value: Exception) : Try<R>()