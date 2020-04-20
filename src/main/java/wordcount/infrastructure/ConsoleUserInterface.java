package wordcount.infrastructure;

import wordcount.domain.UserInterface;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    @Override
    public String getUserInput() {
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void print(int count) {
        System.out.print("Number of words: " + count);
    }

    @Override
    public void printUnique(int count) {
        System.out.print(", unique: " + count);
    }
}
