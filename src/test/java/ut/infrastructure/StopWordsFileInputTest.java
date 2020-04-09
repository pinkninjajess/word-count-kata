package ut.infrastructure;

import org.junit.Test;
import wordcount.infrastructure.StopWordsFileInput;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StopWordsFileInputTest {
    private StopWordsFileInput stopWordsFileInput;

    @Test
    public void getStopWords_fileWithWordsProvided_correctNumberOfWordsLoaded() {
        stopWordsFileInput = new StopWordsFileInput();
        stopWordsFileInput.setFilePath("testfile.txt");

        List<String> stopWords = stopWordsFileInput.getWords();

        assertEquals("Size of the list should be 4", 4, stopWords.size());
    }

    @Test
    public void setFilePath_filePathProvided_correctFilePathIsSet() {
        String filePath = "testfile.txt";
        stopWordsFileInput = new StopWordsFileInput();
        stopWordsFileInput.setFilePath(filePath);

        String filePathFromTest = stopWordsFileInput.getFilePath();

        assertEquals("File path is the same", filePathFromTest, filePathFromTest);
    }
}