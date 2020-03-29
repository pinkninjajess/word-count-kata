package infrastructure;

import domain.StopperWords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class StopperWordsFileInput implements StopperWords {

    public StopperWordsFileInput() throws IOException {
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
