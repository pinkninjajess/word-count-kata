import WordCounter.UserInterface;
import WordCounter.WordCount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class wordCountTest {
    private int wordCount;

    UserInterface ui = new UserInterface() {

        @Override
        public String getUserInput() {
           return "Hello World";
        }

        @Override
        public void printWordCount(int count) {
            wordCount = count;
        }
    };

    @Test
    public void countWordsFromUserInputIsCorrect() {
        final int[] wordCounter = new int[1];

        UserInterface ui = new UserInterface() {

            @Override
            public String getUserInput() {
                return "Hello World";
            }

            @Override
            public void printWordCount(int count) {
                wordCounter[0] = count;
            }
        };

        WordCount wordCount = new WordCount(ui);
        wordCount.countWords();
        assertEquals(0, wordCounter[0]);
        assertEquals(0, this.wordCount);
    }

}
