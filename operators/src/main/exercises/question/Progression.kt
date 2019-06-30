package question

/**
 * Implement a custom Range (x..y) operation for a Fibonacci data class:
 *  - The Fibonacci class needs to implement Comparable
 *  - The Fibonacci should have a lazy variable which calculates the result for the value
 *  - Although it is missing in Kotlin, you will need the following Progression interface below.
 *  - Write a test that tests that the first 5 Fibonacci numbers can be generated.
 */
interface Progression<T : Comparable<T>> : ClosedRange<T>, Iterable<T>
