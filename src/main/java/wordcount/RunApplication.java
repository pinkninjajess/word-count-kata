package wordcount;

import wordcount.domain.StopWords;
import wordcount.domain.UserInterface;
import wordcount.domain.WordCounter;
import wordcount.infrastructure.ConsoleUserInterface;
import wordcount.infrastructure.StopWordsFileInput;

public class RunApplication {

    public static void main(String[] args) {
        UserInterface ui = new ConsoleUserInterface();
        StopWords stopWords = new StopWordsFileInput();
        WordCounter wordCounter = new WordCounter(ui, stopWords);
        wordCounter.countWords();
    }
}
