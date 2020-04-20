package it.wordcount;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import wordcount.RunApplication;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class RunApplicationTest {
    private static final InputStream systemIn = System.in;
    private static final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void runApplication_twoWordsProvided_SystemOutExpectedWithCorrectNumOfWords() {
        String input = "hello world";
        // fake user input into console;
        provideInput(input);

        RunApplication.main(new String[0]);

        assertEquals("Enter text: Number of words: 2, unique: 2", getOutput());
    }

    @Test
    public void runApplication_NineWordsProvidedSevenUniqueWordsProvided_SystemOutExpectedWithCorrectNumOfWords() {
        String input = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        provideInput(input);

        RunApplication.main(new String[0]);

        assertEquals("Enter text: Number of words: 9, unique: 7", getOutput());
    }

    @Test
    public void runApplication_fileNameProvided_SystemOutExpectedWithCorrectNumOfWords() {
        String[] arguments = new String[1];
        arguments[0] = "mytext.txt";

        RunApplication.main(arguments);

        assertEquals("Number of words: 4, unique: 4", getOutput());
    }

    @Test
    public void runApplication_fileContainingDashesProvided_SystemOutExpectedWithCorrectNumOfWords() {
        String[] arguments = new String[1];
        arguments[0] = "mytextwithdashes.txt";

        RunApplication.main(arguments);

        assertEquals("Number of words: 9, unique: 7", getOutput());
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }
}
