import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * This class calculates the sorted list of the set of characters in a particular input file.
 *
 * Convert this file to Kotlin, fix the errors as directed by IntelliJ, then alter the code to use the Kotlin "use" and "try" expressions instead of assignment. The Kotlin extensions to the Java File API will help you here!!
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/java.io.-file/
 *
 * Can you reduce the entire function to a single expression with no return statement?
 */
public class CharacterReader {
    public List<Character> readCharactersFrom(String filename) {
        try {
            File file = new File(filename);
            Reader reader = new FileReader(file);

            HashSet<Character> characters = new HashSet<>();

            try {
                while (true) {
                    int read = reader.read();
                    if (read == -1) break;
                    characters.add((char) read);
                }
            } finally {
                reader.close();
            }

            ArrayList<Character> sorted = new ArrayList<>(characters);
            sorted.sort(Character::compareTo);
            return sorted;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
