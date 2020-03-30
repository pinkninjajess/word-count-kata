package infrastructure;

import domain.StopWords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class StopWordsFileInput implements StopWords {

    private ArrayList<String> stopWords;


    @Override
    public ArrayList<String> getStopWords() {
        try {
            String words = new String(Files.readAllBytes(Paths.get("src/main/java/infrastructure/stopwords.txt")));
            String[] stopWordsArray = words.split("\\s+");
            return new ArrayList<>(Arrays.asList(stopWordsArray));
        } catch (IOException e) {
            return new ArrayList<String>(Arrays.asList(""));
        }
    }

}
