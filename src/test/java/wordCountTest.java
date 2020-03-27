import WordCounter.StopperWords;
import WordCounter.WordCount;
import infrastructure.FileInput;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class wordCountTest {

    @Test
    public void countWords_onlyWordsProvided_IsCorrect() throws IOException {
        FakeUserInterface ui = new FakeUserInterface();
        StopperWords stopperWordsInterface = new FileInput();
        ui.setUserInput("Hello World");
        WordCount wordCount = new WordCount(ui, stopperWordsInterface);
        wordCount.countWords();
        assertEquals(2, ui.getWordCount());
    }

    @Test
    public void countWords_wordsAndNonASCII_countsOnlyWords() throws IOException {
        FakeUserInterface ui = new FakeUserInterface();
        StopperWords stopperWordsInterface = new FileInput();

        ui.setUserInput("H1 th3r3, h0w are y0u? I am doing well");
        WordCount wordCount = new WordCount(ui, stopperWordsInterface);
        wordCount.countWords();
        assertEquals(5, ui.getWordCount());
    }

    @Test
    public void countWords_wordsAndStopperWords_countsOnlyWords() throws IOException {
        FakeUserInterface ui = new FakeUserInterface();
        StopperWords stopperWordsInterface = new FileInput();

        ui.setUserInput("the coffee is on a table");
        WordCount wordCount = new WordCount(ui, stopperWordsInterface);
        wordCount.countWords();

        assertEquals(3, ui.getWordCount());
    }

    @Test
    public void countWords_onlyStopperWords_countsOnlyWords() throws IOException {
        FakeUserInterface ui = new FakeUserInterface();
        StopperWords stopperWordsInterface = new FileInput();

        ui.setUserInput("the on off a");
        WordCount wordCount = new WordCount(ui, stopperWordsInterface);
        wordCount.countWords();

        assertEquals(0, ui.getWordCount());
    }

}
