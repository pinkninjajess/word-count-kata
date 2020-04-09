package wordcount.domain;

import wordcount.infrastructure.StopWordsFileInput;

import java.util.Arrays;
import java.util.List;

public class WordCounter {
    private UserInterface ui;
    private FileInput stopWordsInterface;

    public WordCounter(UserInterface ui, FileInput stopWordsInterface) {
        this.ui = ui;
        this.stopWordsInterface = stopWordsInterface;
    }

    public void countWords() {
        String[] userInput = getUserInput();
        List<String> stopWords = stopWordsInterface.getWords();
        int wordCount = countWordsFrom(userInput, stopWords);
        ui.print(wordCount);
    }

    private String[] getUserInput() {
        String userInput = ui.getUserInput();
        if (userInput.endsWith(".txt")) {
            FileInput fileInput = new StopWordsFileInput();
            fileInput.setFilePath(userInput);
            return (String[]) fileInput.getWords().toArray();
        } else {
            return userInput.split("\\s+");
        }
    }

    private int countWordsFrom(String[] userInput, List<String> stopWords) {
        return (int) Arrays.stream(userInput)
                .filter(this::isAWord)
                .filter(word -> !stopWords.contains(word))
                .count();
    }

    private Boolean isAWord(String input) {
        return input.matches("[a-zA-Z]+");
    }
}
