import domain.StopWords;
import domain.UserInterface;
import domain.WordCounter;
import infrastructure.ConsoleUserInterface;
import infrastructure.StopWordsFileInput;

import java.io.IOException;

public class RunApplication {

    public static void main(String[] args) throws IOException {
        UserInterface ui = new ConsoleUserInterface();
        StopWords stopWords = new StopWordsFileInput();
        WordCounter wordCounter = new WordCounter(ui, stopWords);
        wordCounter.countWords();
    }
}
