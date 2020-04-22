package wordcount.domain;

public interface UserInterface {
    String getUserInput();

    void print(int count);

    void printUnique(int count);

    void printAverage(double wordLength);

    void printIndex(String[] words);
}
