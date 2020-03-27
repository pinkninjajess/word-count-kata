import infrastructure.FileInput;
import infrastructure.UserInput;
import wordcounting.StopperWords;
import wordcounting.UserInterface;
import wordcounting.WordCount;

import java.io.IOException;

public class RunApplication {

    public static void main(String[] args) throws IOException {
        UserInterface UI = new UserInput();
        StopperWords stopperWords = new FileInput();
        WordCount wordCount = new WordCount(UI, stopperWords);
        wordCount.countWords();
    }
}
