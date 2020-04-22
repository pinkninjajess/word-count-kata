package wordcount.domain;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

public class WordCounter {
    private FileInput userFileInput;
    private UserInterface ui;
    private FileInput stopWordsInterface;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public WordCounter(UserInterface ui, FileInput stopWordsInterface, FileInput userFileInput) {
        this.ui = ui;
        this.stopWordsInterface = stopWordsInterface;
        this.userFileInput = userFileInput;
    }

    public void countWords() {
        String userInput = getUserInput();
        List<String> stopWords = stopWordsInterface.getWords();
        String[] words = getFilteredWords(userInput, stopWords);
        int wordCount = countTotalWordsFrom(words);
        int uniqueWordCount = countUniqueWordsFrom(words);
        double averageCharacterCount = countAverageWordLengthFrom(words);
        ui.print(wordCount);
        ui.printUnique(uniqueWordCount);
        ui.printAverage(averageCharacterCount);
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

    private double countAverageWordLengthFrom(String[] words) {
        IntSummaryStatistics statistics = Arrays.stream(words)
                .mapToInt(String::length)
                .summaryStatistics();
        return Double.parseDouble(df2.format(statistics.getAverage()));
    }

    private Boolean isAWord(String input) {
        return input.matches("[a-zA-Z-]+");
    }
}
