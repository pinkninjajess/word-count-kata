package ut.domain;

import domain.StopperWords;
import domain.WordCounter;
import infrastructure.FileInput;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class wordCounterTest {
    FakeUserInterface ui;
    private StopperWords stopperWordsInterface;

    public WordCounter createWordCounterWith(String userInput) throws IOException {
        ui = new FakeUserInterface();
        stopperWordsInterface = new FileInput();
        ui.setUserInput(userInput);
        return new WordCounter(ui, stopperWordsInterface);
    }

    @Test
    public void countWords_oneWord_isCorrect() throws IOException {
        WordCounter wordCounter = createWordCounterWith("Hello");

        wordCounter.countWords();

        assertEquals(1, ui.getWordCount());
    }

    @Test
    public void countWords_onlyWordsProvided_IsCorrect() throws IOException {
        WordCounter wordCounter = createWordCounterWith("Hello World");

        wordCounter.countWords();

        assertEquals(2, ui.getWordCount());
    }

    @Test
    public void countWords_wordWithNumbers_countsZero() throws IOException {
        WordCounter wordCounter = createWordCounterWith("H3110");

        wordCounter.countWords();

        assertEquals(0, ui.getWordCount());
    }

    @Test
    public void countWords_wordWithSpecialSymbols_countsZero() throws IOException {
        WordCounter wordCounter = createWordCounterWith("He11o");

        wordCounter.countWords();

        assertEquals(0, ui.getWordCount());
    }

    @Test
    public void countWords_someWithSpecialSymbols_countsWords() throws IOException {
        WordCounter wordCounter = createWordCounterWith("Hello Wor|d");

        wordCounter.countWords();

        assertEquals(1, ui.getWordCount());
    }

    @Test
    public void countWords_wordWithPeriod_countsNothing() throws IOException {
        WordCounter wordCounter = createWordCounterWith("Word.");

        wordCounter.countWords();

        assertEquals(0, ui.getWordCount());
    }

    @Test
    public void countWords_wordWithComma_countsNothing() throws IOException {
        WordCounter wordCounter = createWordCounterWith("Word,");

        wordCounter.countWords();

        assertEquals(0, ui.getWordCount());
    }

    @Test
    public void countWords_wordsAndNonASCII_countsOnlyWords() throws IOException {
        WordCounter wordCounter = createWordCounterWith("H1 th3r3, h0w are y0u? I am doing well");

        wordCounter.countWords();

        assertEquals(5, ui.getWordCount());
    }

    @Test
    public void countWords_wordsAndStopperWords_countsOnlyWords() throws IOException {
        WordCounter wordCounter = createWordCounterWith("the coffee is on a table");

        wordCounter.countWords();

        assertEquals(3, ui.getWordCount());
    }

    @Test
    public void countWords_onlyStopperWords_countsOnlyWords() throws IOException {
        WordCounter wordCounter = createWordCounterWith("the on off a");

        wordCounter.countWords();

        assertEquals(0, ui.getWordCount());
    }

}
