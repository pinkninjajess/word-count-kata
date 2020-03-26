import WordCounter.UserInterface;

public class FakeUserInterface implements UserInterface {
    private String userInput;
    private int wordCount;

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
    public void printWordCount(int count) {
        setWordCount(count);
    }
}
