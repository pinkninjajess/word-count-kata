import UserInput.UserInput;
import WordCounter.UserInterface;
import WordCounter.WordCount;

public class RunApplication {

    public static void main(String[] args) {
        UserInterface UI = new UserInput();
        WordCount wordCount = new WordCount(UI);
        wordCount.countWords();
    }
}
