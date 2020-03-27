package ut.wordcounting;

import infrastructure.FileInput;
import org.junit.Test;
import wordcounting.StopperWords;
import wordcounting.WordCount;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class wordCounterTest {
    FakeUserInterface ui;
    private StopperWords stopperWordsInterface;

    public WordCount createWordCounterWith(String userInput) throws IOException {
        ui = new FakeUserInterface();
        stopperWordsInterface = new FileInput();
        ui.setUserInput(userInput);
        return new WordCount(ui, stopperWordsInterface);
    }

    @Test
    public void countWords_onlyWordsProvided_IsCorrect() throws IOException {
        WordCount wordCount = createWordCounterWith("Hello World");

        wordCount.countWords();

        assertEquals(2, ui.getWordCount());
    }

    @Test
    public void countWords_wordWithNumbers_countsZero() throws IOException {
        WordCount wordCount = createWordCounterWith("H3110");

        wordCount.countWords();

        assertEquals(0, ui.getWordCount());
    }

    @Test
    public void countWords_wordWithSpecialSymbols_countsZero() throws IOException {
        WordCount wordCount = createWordCounterWith("He11o");

        wordCount.countWords();

        assertEquals(0, ui.getWordCount());
    }

    @Test
    public void countWords_someWithSpecialSymbols_countsWords() throws IOException {
        WordCount wordCount = createWordCounterWith("Hello Wor|d");

        wordCount.countWords();

        assertEquals(1, ui.getWordCount());
    }

    @Test
    public void countWords_wordWithPeriod_countsNothing() throws IOException {
        WordCount wordCounter = createWordCounterWith("Word.");

        wordCounter.countWords();

        assertEquals(0, ui.getWordCount());
    }

    @Test
    public void countWords_wordWithComma_countsNothing() throws IOException {
        WordCount wordCounter = createWordCounterWith("Word,");

        wordCounter.countWords();

        assertEquals(0, ui.getWordCount());
    }

    @Test
    public void countWords_wordsAndNonASCII_countsOnlyWords() throws IOException {
        WordCount wordCounter = createWordCounterWith("H1 th3r3, h0w are y0u? I am doing well");

        wordCounter.countWords();

        assertEquals(5, ui.getWordCount());
    }

    @Test
    public void countWords_wordsAndStopperWords_countsOnlyWords() throws IOException {
        WordCount wordCounter = createWordCounterWith("the coffee is on a table");

        wordCounter.countWords();

        assertEquals(3, ui.getWordCount());
    }

    @Test
    public void countWords_onlyStopperWords_countsOnlyWords() throws IOException {
        WordCount wordCounter = createWordCounterWith("the on off a");

        wordCounter.countWords();

        assertEquals(0, ui.getWordCount());
    }

}
