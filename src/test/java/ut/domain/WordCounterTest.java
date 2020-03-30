package ut.domain;

import org.junit.Test;
import wordcount.domain.StopWords;
import wordcount.domain.WordCounter;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {
    private final FakeUserInterface ui = new FakeUserInterface();

    @Test
    public void countWords_oneWord_countReturnsOne() {
        WordCounter wordCounter = createWordCounterWith("Hello");

        wordCounter.countWords();

        assertEquals(1, ui.getWordCount());
    }

    @Test
    public void countWords_twoWordsSeparatedByWhiteSpace_countReturnsTwo() {
        WordCounter wordCounter = createWordCounterWith("Hello World");

        wordCounter.countWords();

        assertEquals(2, ui.getWordCount());
    }

    @Test
    public void countWords_wordContainingNumbers_countReturnsZero() {
        WordCounter wordCounter = createWordCounterWith("H3110");

        wordCounter.countWords();

        assertEquals(0, ui.getWordCount());
    }

    @Test
    public void countWords_wordContainingSpecialCharacter_countReturnsZero() {
        WordCounter wordCounter = createWordCounterWith("Wor|d");

        wordCounter.countWords();

        assertEquals(0, ui.getWordCount());
    }

    @Test
    public void countWords_wordWithPeriod_countReturnsZero() {
        WordCounter wordCounter = createWordCounterWith("Word.");

        wordCounter.countWords();

        assertEquals(0, ui.getWordCount());
    }

    @Test
    public void countWords_wordWithComma_countReturnsZero() {
        WordCounter wordCounter = createWordCounterWith("Word,");

        wordCounter.countWords();

        assertEquals(0, ui.getWordCount());
    }

    @Test
    public void countWords_wordsAndStopWords_countReturnsThree() {
        StopWords stopWordsFakeInterface = () -> Arrays.asList("a", "the", "on", "off");
        FakeUserInterface fakeUserInterface = new FakeUserInterface();
        fakeUserInterface.setUserInput("the coffee is on a table");
        WordCounter wordCounterForStopWordsTest = new WordCounter(fakeUserInterface, stopWordsFakeInterface);

        wordCounterForStopWordsTest.countWords();

        assertEquals(3, fakeUserInterface.getWordCount());
    }

    @Test
    public void countWords_onlyStopWords_countReturnsZero() {
        StopWords stopWordsFakeInterface = () -> Arrays.asList("a", "the", "on", "off");
        FakeUserInterface fakeUserInterface = new FakeUserInterface();
        fakeUserInterface.setUserInput("the on off a");
        WordCounter wordCounterForStopWordsTest = new WordCounter(fakeUserInterface, stopWordsFakeInterface);

        wordCounterForStopWordsTest.countWords();

        assertEquals(0, fakeUserInterface.getWordCount());
    }

    public WordCounter createWordCounterWith(String userInput) {
        StopWords stopWordsInterface = new FakeStopWordsFileInput();
        ui.setUserInput(userInput);
        return new WordCounter(ui, stopWordsInterface);
    }
}
