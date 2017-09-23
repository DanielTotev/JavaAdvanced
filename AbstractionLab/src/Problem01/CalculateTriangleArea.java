package Problem01;

import java.util.Scanner;

public class CalculateTriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double base = scanner.nextDouble();
        double height = scanner.nextDouble();
        double area = calculateTriangleArea(base, height);
        System.out.printf("Area = %.2f" + System.lineSeparator(), area);
    }

    private static double calculateTriangleArea(double base, double height){
        return (base * height) / 2.0;
    }
}
