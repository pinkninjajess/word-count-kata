package wordcount;

import wordcount.domain.FileInput;
import wordcount.domain.UserInterface;
import wordcount.domain.WordCounter;
import wordcount.infrastructure.ConsoleUserInterface;
import wordcount.infrastructure.StopWordsFileInput;

public class RunApplication {

    public static void main(String[] args) {
        UserInterface ui = new ConsoleUserInterface();
        FileInput stopWords = new StopWordsFileInput();
        stopWords.setFilePath("stopwords.txt");
        WordCounter wordCounter = new WordCounter(ui, stopWords);
        wordCounter.countWords();
    }
}
