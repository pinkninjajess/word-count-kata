package wordcounting;


import java.util.ArrayList;
import java.util.Arrays;

public class WordCount {

    private UserInterface UI;
    private StopperWords stopperWordsInterface;

    public WordCount(UserInterface UI, StopperWords stopperWordsInterface) {
        this.UI = UI;
        this.stopperWordsInterface = stopperWordsInterface;
    }

    public void countWords() {
        String userInput = UI.getUserInput();
        ArrayList<String> stopperWords = stopperWordsInterface.getStopperWords();
        int count = countWordsFrom(userInput, stopperWords);
        UI.printWordCount(count);
    }

    private int countWordsFrom(String userInput, ArrayList<String> stopperWords) {
        return (int) Arrays.stream(userInput.split(" "))
                .filter(this::isAWord)
                .filter(word -> !stopperWords.contains(word))
                .count();
    }

    private Boolean isAWord(String input) {
        return input.matches("[a-zA-Z]+");
    }


}
