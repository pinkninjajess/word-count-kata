package ut.domain;

import wordcount.domain.UserInterface;

public class FakeUserInterface implements UserInterface {
    private String userInput;
    private int wordCount;
    private int uniqueWordCount;

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
}
