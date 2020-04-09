package wordcount;

import wordcount.domain.FileInput;
import wordcount.domain.UserInterface;
import wordcount.domain.WordCounter;
import wordcount.infrastructure.ConsoleUserInterface;
import wordcount.infrastructure.WordsFileInput;

public class RunApplication {

    public static void main(String[] args) {
        UserInterface ui = new ConsoleUserInterface();
        FileInput stopWords = new WordsFileInput();
        FileInput userFileInput = new WordsFileInput();
        stopWords.setFilePath("stopwords.txt");
        WordCounter wordCounter = new WordCounter(ui, stopWords, userFileInput);
        wordCounter.countWords();
    }
}
