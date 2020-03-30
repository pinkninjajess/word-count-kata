package infrastructure;

import domain.StopWords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StopWordsFileInput implements StopWords {

    private ArrayList<String> stopWords;
    private static final Logger LOGGER = Logger.getLogger(StopWordsFileInput.class.getName());

    @Override
    public List<String> getStopWords() {
        try {
            String words = new String(Files.readAllBytes(Paths.get("src/main/java/infrastructure/stopwordse.txt")));
            String[] stopWordsArray = words.split("\\s+");
            return new ArrayList<>(Arrays.asList(stopWordsArray));
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Loading of stop words from file failed");
            return Collections.emptyList();
        }
    }

}
