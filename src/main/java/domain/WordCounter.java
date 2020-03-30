package domain;


import java.util.ArrayList;
import java.util.Arrays;

public class WordCounter {

    private UserInterface ui;
    private StopWords stopWordsInterface;

    public WordCounter(UserInterface ui, StopWords stopWordsInterface) {
        this.ui = ui;
        this.stopWordsInterface = stopWordsInterface;
    }

    public void countWords() {
        String userInput = ui.getUserInput();
        ArrayList<String> stopperWords = stopWordsInterface.getStopWords();
        int wordCount = countWordsFrom(userInput, stopperWords);
        ui.print(wordCount);
    }

    private int countWordsFrom(String userInput, ArrayList<String> stopperWords) {
        return (int) Arrays.stream(userInput.split("\\s+"))
                .filter(this::isAWord)
                .filter(word -> !stopperWords.contains(word))
                .count();
    }

    private Boolean isAWord(String input) {
        return input.matches("[a-zA-Z]+");
    }


}
