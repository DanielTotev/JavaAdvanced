package Problem03;

import java.util.Scanner;

public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNumber = scanner.nextDouble();
        double secondNumber = scanner.nextDouble();
        double thirdNumber = scanner.nextDouble();
        double average = (firstNumber + secondNumber + thirdNumber) / 3.0;
        System.out.printf("%.2f" + System.lineSeparator(), average);
    }
}
