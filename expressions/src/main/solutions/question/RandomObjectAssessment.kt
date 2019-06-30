package question

import java.lang.Integer.parseInt
import java.time.LocalDateTime

class RandomObjectAssessment {
    fun judge(o: Any): String = when {
        o in listOf(1, 2) -> "o is one or two"
        o is Double -> "o is a double, so the tan of it is " + Math.tan(o)
        o in listOf(17, 18, 19) -> "o is either 17, 18, or 19"
        o is LocalDateTime -> "o is a datetime. yesterday was " + o.toLocalDate().toString()
        parseInt(o.toString()) in 4..11 -> "o is between 4 and 11"
        else -> "o is none of the above"
    }
}