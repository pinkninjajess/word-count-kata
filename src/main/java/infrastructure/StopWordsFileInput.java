package infrastructure;

import domain.StopWords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class StopWordsFileInput implements StopWords {

    private ArrayList<String> stopWords;

    public StopWordsFileInput() throws IOException {
        String words = new String(Files.readAllBytes(Paths.get("src/main/java/infrastructure/stopwords.txt")));
        String[] stopWordsArray = words.split("\\s+");
        this.stopWords = new ArrayList<>(Arrays.asList(stopWordsArray));
    }

    @Override
    public ArrayList<String> getStopWords() {
        return stopWords;
    }

}
