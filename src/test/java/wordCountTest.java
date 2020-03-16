import WordCounter.UserInterface;
import WordCounter.WordCount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class wordCountTest {

    @Test
    public void countWords_onlyWordsProvided_IsCorrect() {
        UserInterface ui = new FakeUserInterface();
        ((FakeUserInterface) ui).setUserInput("Hello World");
        WordCount wordCount = new WordCount(ui);
        wordCount.countWords();
        assertEquals(2, ((FakeUserInterface) ui).getWordCount());
    }

    @Test
    public void countWords_wordsAndNonASCII_countsOnlyWords() {
        UserInterface ui = new FakeUserInterface();
        ((FakeUserInterface) ui).setUserInput("H1 th3r3, h0w are y0u? I am doing well");
        WordCount wordCount = new WordCount(ui);
        wordCount.countWords();
        assertEquals(5, ((FakeUserInterface) ui).getWordCount());
    }

}
