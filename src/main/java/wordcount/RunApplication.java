package wordcount;

import wordcount.domain.FileInput;
import wordcount.domain.UserInterface;
import wordcount.domain.WordCounter;
import wordcount.infrastructure.ConsoleUserInterface;
import wordcount.infrastructure.WordsFileInput;

public class RunApplication {
    private static final String STOP_WORDS_FILE_PATH = "stopwords.txt";

    public static void main(String[] args) {
        FileInput userFileInput = new WordsFileInput();

        boolean showIndex = false;
        if (args.length > 0) {
            for (String argument : args) {
                if (argument.compareToIgnoreCase("-index") == 0) {
                    showIndex = true;
                } else {
                    userFileInput.setFilePath(argument);
                }
            }
        }

        UserInterface ui = new ConsoleUserInterface();
        FileInput stopWords = new WordsFileInput();
        stopWords.setFilePath(STOP_WORDS_FILE_PATH);
        WordCounter wordCounter = new WordCounter(ui, stopWords, userFileInput, showIndex);
        wordCounter.countWords();
    }
}
