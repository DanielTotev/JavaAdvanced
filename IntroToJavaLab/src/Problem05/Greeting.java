package Problem05;

import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        if (firstName.isEmpty()){
            firstName = "*****";
        }
        String lastName = scanner.nextLine();
        if (lastName.isEmpty()){
            lastName = "*****";
        }
        System.out.println("Hello, " + firstName + " " + lastName + "!");
    }
}
