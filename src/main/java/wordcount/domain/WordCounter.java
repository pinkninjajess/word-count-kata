package wordcount.domain;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

public class WordCounter {
    private static final DecimalFormat df2 = new DecimalFormat("#.##");
    private final FileInput userFileInput;
    private final UserInterface ui;
    private final FileInput stopWordsInterface;

    public WordCounter(UserInterface ui, FileInput stopWordsInterface, FileInput userFileInput) {
        this.ui = ui;
        this.stopWordsInterface = stopWordsInterface;
        this.userFileInput = userFileInput;
    }

    public void countWords() {
        String userInput = getUserInput();
        List<String> stopWords = stopWordsInterface.getWords();
        String[] words = getFilteredWords(userInput, stopWords);
        String[] indexWords = getUniqueWordsFrom(words);
        int wordCount = countTotalFrom(words);
        int uniqueWordCount = countTotalFrom(getUniqueWordsFrom(words));
        double averageCharacterCount = countAverageWordLengthFrom(words);
        ui.print(wordCount);
        ui.printUnique(uniqueWordCount);
        ui.printAverage(averageCharacterCount);
        ui.printIndex(indexWords);
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

    private int countTotalFrom(String[] words) {
        return words.length;
    }

    private String[] getUniqueWordsFrom(String[] words) {
        Stream<String> stream = Arrays.stream(words)
                .distinct()
                .sorted(String::compareToIgnoreCase);
        return stream.toArray(String[]::new);
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
