package WordCounter;


import java.util.Arrays;

public class WordCount {

    private UserInterface UI;

    public WordCount(UserInterface UI) {
        this.UI = UI;
    }

    public void countWords() {
        String userInput = UI.getUserInput();
        int count = countWordsFrom(userInput);
        UI.printWordCount(count);
    }

    private int countWordsFrom(String userInput) {
        return (int) Arrays.stream(userInput.split(" "))
                .filter(this::isAWord)
                .count();
    }

    private Boolean isAWord(String input) {
        return input.matches("[a-zA-Z]+");
    }


}
