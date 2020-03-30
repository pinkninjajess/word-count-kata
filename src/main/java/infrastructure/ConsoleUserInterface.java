package infrastructure;

import domain.UserInterface;

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
        System.out.println("Number of words: " + count);
    }


}
