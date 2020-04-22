package ut.domain;

import wordcount.domain.UserInterface;

public class FakeUserInterface implements UserInterface {
    private String userInput;
    private int wordCount;
    private int uniqueWordCount;
    private double averageWordLength;
    private String[] index;

    public String[] getIndex() {
        return index;
    }

    public void setIndex(String[] index) {
        this.index = index;
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }

    public void setAverageWordLength(double averageWordLength) {
        this.averageWordLength = averageWordLength;
    }

    public int getUniqueWordCount() {
        return uniqueWordCount;
    }

    public void setUniqueWordCount(int uniqueWordCount) {
        this.uniqueWordCount = uniqueWordCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    @Override
    public String getUserInput() {
        return this.userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public void print(int count) {
        setWordCount(count);
    }

    @Override
    public void printUnique(int count) {
        setUniqueWordCount(count);
    }

    @Override
    public void printAverage(double wordLength) {
        setAverageWordLength(wordLength);
    }

    @Override
    public void printIndex(String[] words) {
        setIndex(words);
    }
}
