import java.util.List;

/**
 * Implement MessageEncoder that:
 * - Only encodes messages over 10 characters - messages of less than 10 characters are ignored
 * - Returns a list of the non-vowel characters in the message with the count of that character,
 * space separated and sorted alphabetically.
 *
 * e.g. "Hello There" becomes "h2 l2 r1 t1"
 */
public interface MessageEncoder {
    List<String> encode(List<String> messages);
}

