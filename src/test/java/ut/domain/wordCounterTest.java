package ut.domain;

import domain.StopWords;
import domain.WordCounter;
import infrastructure.StopWordsFileInput;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class wordCounterTest {
    FakeUserInterface ui;
    private StopWords stopWordsInterface;

    public WordCounter createWordCounterWith(String userInput) {
        ui = new FakeUserInterface();
        stopWordsInterface = new StopWordsFileInput();
        ui.setUserInput(userInput);
        return new WordCounter(ui, stopWordsInterface);
    }

    @Test
    public void countWords_oneWord_isCorrect() {
        WordCounter wordCounter = createWordCounterWith("Hello");

        wordCounter.countWords();

        assertEquals(1, ui.getWordCount());
    }

    @Test
    public void countWords_onlyWordsProvided_IsCorrect() {
        WordCounter wordCounter = createWordCounterWith("Hello World");

        wordCounter.countWords();

        assertEquals(2, ui.getWordCount());
    }

    @Test
    public void countWords_wordWithNumbers_countsZero() {
        WordCounter wordCounter = createWordCounterWith("H3110");

        wordCounter.countWords();

        assertEquals(0, ui.getWordCount());
    }

    @Test
    public void countWords_wordWithSpecialSymbols_countsZero() {
        WordCounter wordCounter = createWordCounterWith("He11o");

        wordCounter.countWords();

        assertEquals(0, ui.getWordCount());
    }

    @Test
    public void countWords_someWithSpecialSymbols_countsWords() {
        WordCounter wordCounter = createWordCounterWith("Hello Wor|d");

        wordCounter.countWords();

        assertEquals(1, ui.getWordCount());
    }

    @Test
    public void countWords_wordWithPeriod_countsNothing() {
        WordCounter wordCounter = createWordCounterWith("Word.");

        wordCounter.countWords();

        assertEquals(0, ui.getWordCount());
    }

    @Test
    public void countWords_wordWithComma_countsNothing() {
        WordCounter wordCounter = createWordCounterWith("Word,");

        wordCounter.countWords();

        assertEquals(0, ui.getWordCount());
    }

    @Test
    public void countWords_wordsAndNonASCII_countsOnlyWords() {
        WordCounter wordCounter = createWordCounterWith("H1 th3r3, h0w are y0u? I am doing well");

        wordCounter.countWords();

        assertEquals(5, ui.getWordCount());
    }

    @Test
    public void countWords_wordsAndStopperWords_countsOnlyWords() {
        WordCounter wordCounter = createWordCounterWith("the coffee is on a table");

        wordCounter.countWords();

        assertEquals(3, ui.getWordCount());
    }

    @Test
    public void countWords_onlyStopperWords_countsOnlyWords() {
        WordCounter wordCounter = createWordCounterWith("the on off a");

        wordCounter.countWords();

        assertEquals(0, ui.getWordCount());
    }

}
