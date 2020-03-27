import WordCounter.StopperWords;
import WordCounter.UserInterface;
import WordCounter.WordCount;
import infrastructure.FileInput;
import infrastructure.UserInput;

import java.io.IOException;

public class RunApplication {

    public static void main(String[] args) throws IOException {
        UserInterface UI = new UserInput();
        StopperWords stopperWords = new FileInput();
        stopperWords.setStopperWords("src/main/java/infrastructure/StopperWordsFile");
        WordCount wordCount = new WordCount(UI, stopperWords);
        wordCount.countWords();
    }
}
