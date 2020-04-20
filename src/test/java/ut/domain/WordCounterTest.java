package ut.domain;

import org.junit.Test;
import wordcount.domain.FileInput;
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
    public void countWords_fourWordsWithDashesSeparatedByWhiteSpace_countReturnsTwo() {
        WordCounter wordCounter = createWordCounterWith("Sally-Anne Bob-Town");

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
    public void countWords_wordWithPeriod_countReturnsOne() {
        WordCounter wordCounter = createWordCounterWith("Word.");

        wordCounter.countWords();

        assertEquals(1, ui.getWordCount());
    }

    @Test
    public void countWords_wordWithComma_countReturnsOne() {
        WordCounter wordCounter = createWordCounterWith("Word,");

        wordCounter.countWords();

        assertEquals(1, ui.getWordCount());
    }

    @Test
    public void countWords_repeatedWords_uniqueCountReturnsOne() {
        WordCounter wordCounter = createWordCounterWith("hi hi");

        wordCounter.countWords();

        assertEquals(1, ui.getUniqueWordCount());
    }

    @Test
    public void countWords_wordsAndStopWords_countReturnsThree() {
        FakeFileInput stopWordsFakeInterface = new FakeFileInput();
        stopWordsFakeInterface.setWords(Arrays.asList("a", "the", "on", "off"));
        FileInput userFileInput = new FakeFileInput();
        FakeUserInterface fakeUserInterface = new FakeUserInterface();
        fakeUserInterface.setUserInput("the coffee is on a table");
        WordCounter wordCounterForStopWordsTest = new WordCounter(fakeUserInterface, stopWordsFakeInterface, userFileInput);

        wordCounterForStopWordsTest.countWords();

        assertEquals(3, fakeUserInterface.getWordCount());
    }

    @Test
    public void countWords_onlyStopWords_countReturnsZero() {
        FakeFileInput stopWordsFakeInterface = new FakeFileInput();
        stopWordsFakeInterface.setWords(Arrays.asList("a", "the", "on", "off"));
        FileInput userFileInput = new FakeFileInput();
        FakeUserInterface fakeUserInterface = new FakeUserInterface();
        fakeUserInterface.setUserInput("the on off a");
        WordCounter wordCounterForStopWordsTest = new WordCounter(fakeUserInterface, stopWordsFakeInterface, userFileInput);

        wordCounterForStopWordsTest.countWords();

        assertEquals(0, fakeUserInterface.getWordCount());
    }

    @Test
    public void countWords_wordsFromFakeUserProvidedFile_countReturnsTwo() {
        FakeFileInput stopWordsFakeInterface = new FakeFileInput();
        FakeUserInterface fakeUserInterface = new FakeUserInterface();
        fakeUserInterface.setUserInput("fakefileinput.txt");
        FakeFileInput fakeUserFileInput = new FakeFileInput();
        fakeUserFileInput.setWords(Arrays.asList("hello", "world"));
        WordCounter wordCounterForStopWordsTest = new WordCounter(fakeUserInterface, stopWordsFakeInterface, fakeUserFileInput);

        wordCounterForStopWordsTest.countWords();

        assertEquals(2, fakeUserInterface.getWordCount());
    }

    @Test
    public void countWords_wordsAndStopWordsFromFakeUserProvidedFile_countReturnsFour() {
        FakeFileInput stopWordsFakeInterface = new FakeFileInput();
        stopWordsFakeInterface.setWords(Arrays.asList("the", "on", "off", "a"));
        FakeUserInterface fakeUserInterface = new FakeUserInterface();
        fakeUserInterface.setUserInput("fakefileinput.txt");
        FakeFileInput fakeUserFileInput = new FakeFileInput();
        fakeUserFileInput.setWords(Arrays.asList("mary", "had", "a", "little", "lamb"));
        WordCounter wordCounterForStopWordsTest = new WordCounter(fakeUserInterface, stopWordsFakeInterface, fakeUserFileInput);

        wordCounterForStopWordsTest.countWords();

        assertEquals(4, fakeUserInterface.getWordCount());
    }

    @Test
    public void countWords_wordsStopWordsAndDashes_totalCountReturnsNineUniqueCountReturnsSeven() {
        FakeFileInput stopWordsFakeInterface = new FakeFileInput();
        FakeFileInput fakeFileInput = new FakeFileInput();
        stopWordsFakeInterface.setWords(Arrays.asList("the", "a", "on", "off"));
        FakeUserInterface fakeUserInterface = new FakeUserInterface();
        fakeUserInterface.setUserInput("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        WordCounter wordCounter = new WordCounter(fakeUserInterface, stopWordsFakeInterface, fakeFileInput);

        wordCounter.countWords();

        assertEquals(7, fakeUserInterface.getWordCount());
        assertEquals(6, fakeUserInterface.getUniqueWordCount());
    }

    public WordCounter createWordCounterWith(String userInput) {
        FileInput stopWordsInterface = new FakeFileInput();
        FileInput userFileInput = new FakeFileInput();
        ui.setUserInput(userInput);
        return new WordCounter(ui, stopWordsInterface, userFileInput);
    }
}
