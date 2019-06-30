

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class takes a CSV list of filenames, adds .txt if missing, then reads all the contents out of the file, or creates it
 * and returns "<empty file>" if it doesn't exist.
 *
 * Convert this file to Kotlin, then alter the code to use the Kotlin "let" expression instead of assignment
 *
 * Can you reduce the entire function to a single expression with no return statement?
 */
public class FileContents {
    public List<String> contentsOf(String csvFileNames) throws IOException {
        String[] fileNames = csvFileNames.split(",");
        List<String> allContents = new ArrayList<>();

        for (String fileName : fileNames) {
            File f;
            if(!fileName.endsWith(".txt"))
                f = new File(fileName + ".txt");
            else {
                f = new File(fileName);
            }

            String outputContent;
            if(!f.exists()) {
                try {
                    f.createNewFile();
                    outputContent = "<empty file>";
                } catch (IOException e) {
                    outputContent = "<could not create>";
                }
            } else {
                outputContent = Files.readAllLines(f.toPath()).stream().collect(Collectors.joining(","));
            }
            allContents.add(f.getName() + ":" + outputContent.substring(0, 10));
        }
        return allContents;
    }
}
