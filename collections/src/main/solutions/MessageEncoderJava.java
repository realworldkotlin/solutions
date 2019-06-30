import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MessageEncoderJava implements MessageEncoder {

    private static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public List<String> encode(List<String> messages) {
        return messages.stream()
            .filter(message -> message.length() > 10)
            .map(String::toLowerCase)
            .map(message -> {
                    String withoutVowels = vowels.stream()
                        .map(in -> Character.toString(in))
                        .reduce(message, (memo, next) -> memo.replace(next, ""));

                    Map<Character, List<Character>> letterCounts =
                        withoutVowels.chars().mapToObj(i -> (char) i)
                            .collect(Collectors.groupingBy(c -> c));

                    return letterCounts.entrySet().stream()
                        .filter(group -> group.getKey() != ' ')
                        .map(entry -> entry.getKey().toString() + entry.getValue().size())
                        .sorted()
                        .collect(Collectors.joining(" "));
                }
            )
            .collect(Collectors.toList());
    }
}
