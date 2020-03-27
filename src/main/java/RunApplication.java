import domain.StopperWords;
import domain.UserInterface;
import domain.WordCounter;
import infrastructure.FileInput;
import infrastructure.UserInput;

import java.io.IOException;

public class RunApplication {

    public static void main(String[] args) throws IOException {
        UserInterface ui = new UserInput();
        StopperWords stopperWords = new FileInput();
        WordCounter wordCounter = new WordCounter(ui, stopperWords);
        wordCounter.countWords();
    }
}
