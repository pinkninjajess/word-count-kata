package infrastructure;

import WordCounter.StopperWords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileInput implements StopperWords {

    public FileInput() throws IOException {
        String words = new String(Files.readAllBytes(Paths.get("src/main/java/infrastructure/StopperWordsFile")));
        String[] stopperWordsArray = words.split("\\s+");
        this.stopperWords = new ArrayList<>(Arrays.asList(stopperWordsArray));
    }

    private ArrayList<String> stopperWords;

    @Override
    public ArrayList<String> getStopperWords() {
        return stopperWords;
    }

}
