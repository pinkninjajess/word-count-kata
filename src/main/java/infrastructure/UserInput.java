package infrastructure;

import domain.UserInterface;

import java.util.Scanner;

public class UserInput implements UserInterface {
    @Override
    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void print(int count) {
        System.out.println(count);
    }


}
