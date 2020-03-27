package WordCounter;

import java.io.IOException;
import java.util.ArrayList;

public interface StopperWords {
    ArrayList<String> getStopperWords();

    void setStopperWords(String stopperWordsFilePath) throws IOException;
}
