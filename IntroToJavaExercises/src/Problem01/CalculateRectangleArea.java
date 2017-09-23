package Problem01;

import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sideA = scanner.nextDouble();
        double sideB = scanner.nextDouble();
        System.out.printf("%.2f", (sideA * sideB));
    }
}
