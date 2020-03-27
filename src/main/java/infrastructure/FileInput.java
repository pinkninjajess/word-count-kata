package infrastructure;

import WordCounter.StopperWords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileInput implements StopperWords {
    private ArrayList<String> stopperWords;

    @Override
    public ArrayList<String> getStopperWords() {
        return stopperWords;
    }

    @Override
    public void setStopperWords(String stopperWordsFilePath) throws IOException {
        // get file input
        String words = new String(Files.readAllBytes(Paths.get(stopperWordsFilePath)));
        String[] stopperWordsArray = words.split("\\s+");
        this.stopperWords = new ArrayList<>(Arrays.asList(stopperWordsArray));
    }

}
