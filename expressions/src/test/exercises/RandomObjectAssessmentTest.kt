import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime

class RandomObjectAssessmentTest {

    @Test
    fun `expected cases`() {
        assertEquals("o is one or two", RandomObjectAssessment().judge(1))
        assertEquals("o is a double, so the tan of it is -2.185039863261519", RandomObjectAssessment().judge(2.0))
        assertEquals("o is between 4 and 11", RandomObjectAssessment().judge("7"))
        assertEquals("o is between 4 and 11", RandomObjectAssessment().judge(7))
        assertEquals("o is either 17, 18, or 19", RandomObjectAssessment().judge(18))
        assertEquals("o is a datetime. yesterday was 2000-01-01", RandomObjectAssessment().judge(LocalDateTime.of(2000, 1, 1, 1, 1)))
        assertEquals("o is none of the above", RandomObjectAssessment().judge(237))
    }
}
