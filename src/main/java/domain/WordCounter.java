package domain;


import java.util.ArrayList;
import java.util.Arrays;

public class WordCounter {

    private UserInterface ui;
    private StopperWords stopperWordsInterface;

    public WordCounter(UserInterface ui, StopperWords stopperWordsInterface) {
        this.ui = ui;
        this.stopperWordsInterface = stopperWordsInterface;
    }

    public void countWords() {
        String userInput = ui.getUserInput();
        ArrayList<String> stopperWords = stopperWordsInterface.getStopperWords();
        int count = countWordsFrom(userInput, stopperWords);
        ui.print(count);
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
