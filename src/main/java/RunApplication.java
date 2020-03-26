import WordCounter.StopperWords;
import WordCounter.UserInterface;
import WordCounter.WordCount;
import infrastructure.FileInput;
import infrastructure.UserInput;

public class RunApplication {

    public static void main(String[] args) {
        UserInterface UI = new UserInput();
        StopperWords stopperWords = new FileInput();
        WordCount wordCount = new WordCount(UI, stopperWords);
        wordCount.countWords();
    }
}
