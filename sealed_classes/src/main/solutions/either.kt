/**
 * Implement a Either type as a sealed class:
 *  - Try has 2 implementations: Left<L> and Right<R>
 *  - Implement orThrow(), which returns the right value or throws an exception
 *  - Implement map(), which takes a function: R -> Y and returns a Either<L, Y>
 *  - Implement flatMap(), which takes a function: R -> Either<L, Y> and returns a Either<L, Y>
 *  - Implement mapLeft(), which takes a function: L -> Y and returns a Either<Y, R>
 *  - Implement flatMapLeft(), which takes a function: L -> Either<Y, R> and returns a Either<Y, R>
 *  - Bonus* - Make Either<L, R> iterable
 */

sealed class Either<L, R> : Iterable<R> {
    fun <NEXT> map(fn: (R) -> NEXT): Either<L, NEXT> = when (this) {
        is Right -> Right(fn(value))
        is Left -> Left(value)
    }

    fun <NEXT> mapLeft(fn: (L) -> NEXT): Either<NEXT, R> = when (this) {
        is Right -> Right(value)
        is Left -> Left(fn(value))
    }

    fun <NEXT> flatMap(fn: (R) -> Either<L, NEXT>): Either<L, NEXT> = when (this) {
        is Right -> fn(value)
        is Left -> Left(value)
    }

    fun <NEXT> flatMapLeft(fn: (L) -> Either<NEXT, R>): Either<NEXT, R> = when (this) {
        is Right -> Right(value)
        is Left -> fn(value)
    }

    override fun iterator(): Iterator<R> = when (this) {
        is Right -> listOf(value)
        is Left -> emptyList()
    }.iterator()

    fun right(): R = when (this) {
        is Right -> value
        is Left -> throw IllegalArgumentException("Left is $value")
    }

    fun left(): L = when (this) {
        is Left -> value
        is Right -> throw IllegalArgumentException("Right is $value")
    }
}

data class Right<L, R>(internal val value: R) : Either<L, R>()
data class Left<L, R>(internal val value: L) : Either<L, R>()
