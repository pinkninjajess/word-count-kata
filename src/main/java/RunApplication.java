import domain.StopperWords;
import domain.UserInterface;
import domain.WordCounter;
import infrastructure.ConsoleUserInterface;
import infrastructure.StopperWordsFileInput;

import java.io.IOException;

public class RunApplication {

    public static void main(String[] args) throws IOException {
        UserInterface ui = new ConsoleUserInterface();
        StopperWords stopperWords = new StopperWordsFileInput();
        WordCounter wordCounter = new WordCounter(ui, stopperWords);
        wordCounter.countWords();
    }
}
