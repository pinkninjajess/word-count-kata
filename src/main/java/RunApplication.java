import domain.StopWords;
import domain.UserInterface;
import domain.WordCounter;
import infrastructure.ConsoleUserInterface;
import infrastructure.StopWordsFileInput;

public class RunApplication {

    public static void main(String[] args) {
        UserInterface ui = new ConsoleUserInterface();
        StopWords stopWords = new StopWordsFileInput();
        WordCounter wordCounter = new WordCounter(ui, stopWords);
        wordCounter.countWords();
    }
}
