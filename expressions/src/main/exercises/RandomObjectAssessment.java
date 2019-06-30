

import java.time.LocalDateTime;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

/**
 * Convert this file to Kotlin, then alter the code to use the Kotlin "when" expression.
 *
 * Can you reduce the entire function to a single expression with no return statement?
 */
public class RandomObjectAssessment {
    public String judge(Object o) {
        if (o.equals(1) || o.equals(2)) {
            return "o is one or two";
        } else if (o instanceof Double) {
            return "o is a double, so the tan of it is " + Math.tan((double) o);
        } else if (o instanceof LocalDateTime) {
            return "o is a datetime. yesterday was " + ((LocalDateTime) o).toLocalDate().toString();
        } else if (parseInt(o.toString()) > 3 && parseInt(o.toString()) < 12) {
            return "o is between 4 and 11";
        } else if (Arrays.asList(17, 18, 19).contains(parseInt(o.toString()))) {
            return "o is either 17, 18, or 19";
        } else {
            return "o is none of the above";
        }
    }
}