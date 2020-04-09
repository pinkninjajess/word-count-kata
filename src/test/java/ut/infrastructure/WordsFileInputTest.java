package ut.infrastructure;

import org.junit.Test;
import wordcount.infrastructure.WordsFileInput;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordsFileInputTest {
    private WordsFileInput wordsFileInput;

    @Test
    public void getStopWords_fileWithWordsProvided_correctNumberOfWordsLoaded() {
        wordsFileInput = new WordsFileInput();
        wordsFileInput.setFilePath("testfile.txt");

        List<String> stopWords = wordsFileInput.getWords();

        assertEquals("Size of the list should be 4", 4, stopWords.size());
    }

    @Test
    public void setFilePath_filePathProvided_correctFilePathIsSet() {
        String filePath = "testfile.txt";
        wordsFileInput = new WordsFileInput();
        wordsFileInput.setFilePath(filePath);

        String filePathFromTest = wordsFileInput.getFilePath();

        assertEquals("File path is the same", filePathFromTest, filePathFromTest);
    }
}