package ut.infrastructure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import wordcount.infrastructure.ConsoleUserInterface;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ConsoleUserInterfaceTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
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
    public void getUserInput_oneWordProvided_SameSingleWordReturned() {
        final String testString = "Hello";

        provideInput(testString);
        ConsoleUserInterface consoleUserInterface = new ConsoleUserInterface();

        assertEquals(testString, consoleUserInterface.getUserInput());
    }

    @Test
    public void getUserInput_twoWordsProvided_SameTwoWordsReturned() {
        final String testString = "Hello World";

        provideInput(testString);
        ConsoleUserInterface consoleUserInterface = new ConsoleUserInterface();

        assertEquals(testString, consoleUserInterface.getUserInput());
    }


    @Test
    public void getOutput_singleDigitProvided_printsDescriptionAndSingleDigit() {
        ConsoleUserInterface consoleUserInterface = new ConsoleUserInterface();

        consoleUserInterface.print(1);

        assertEquals("Number of words: 1", getOutput());
    }

    @Test
    public void getOutput_doubleDigitsProvided_printsDescriptionAndDoubleDigits() {
        ConsoleUserInterface consoleUserInterface = new ConsoleUserInterface();

        consoleUserInterface.print(22);

        assertEquals("Number of words: 22", getOutput());
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }
}
