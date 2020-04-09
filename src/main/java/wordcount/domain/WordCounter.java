package wordcount.domain;

import java.util.Arrays;
import java.util.List;

public class WordCounter {
    private FileInput userFileInput;
    private UserInterface ui;
    private FileInput stopWordsInterface;

    public WordCounter(UserInterface ui, FileInput stopWordsInterface, FileInput userFileInput) {
        this.ui = ui;
        this.stopWordsInterface = stopWordsInterface;
        this.userFileInput = userFileInput;
    }

    public void countWords() {
        String userInput = getUserInput();
        List<String> stopWords = stopWordsInterface.getWords();
        int wordCount = countWordsFrom(userInput, stopWords);
        ui.print(wordCount);
    }

    private String getUserInput() {
        String userInput = ui.getUserInput();
        if (userInput.endsWith(".txt")) {
            userFileInput.setFilePath(userInput);
            return String.join(" ", userFileInput.getWords());
        } else {
            return userInput;
        }
    }

    private int countWordsFrom(String userInput, List<String> stopWords) {
        return (int) Arrays.stream(userInput.split("\\s+"))
                .filter(this::isAWord)
                .filter(word -> !stopWords.contains(word))
                .count();
    }

    private Boolean isAWord(String input) {
        return input.matches("[a-zA-Z]+");
    }
}
