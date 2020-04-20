package wordcount.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
        String[] wordStream = getFilteredWords(userInput, stopWords);
        int wordCount = countTotalWordsFrom(wordStream);
        int uniqueWordCount = countUniqueWordsFrom(wordStream);
        ui.print(wordCount);
        ui.printUnique(uniqueWordCount);
    }

    private String getUserInput() {
        if (!userFileInput.getWords().isEmpty()) {
            return String.join(" ", userFileInput.getWords());
        } else {
            return ui.getUserInput();
        }
    }

    private String[] getFilteredWords(String userInput, List<String> stopWords) {
        Stream<String> stream = Arrays.stream(userInput.split("[\\s.,]+"))
                .filter(this::isAWord)
                .filter(word -> !stopWords.contains(word));

        return stream.toArray(String[]::new);
    }

    private int countTotalWordsFrom(String[] words) {
        return words.length;
    }

    private int countUniqueWordsFrom(String[] words) {
        return (int) Arrays.stream(words)
                .distinct().count();
    }

    private Boolean isAWord(String input) {
        return input.matches("[a-zA-Z-]+");
    }
}
