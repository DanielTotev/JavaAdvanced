package Problem04;

import java.util.Arrays;
import java.util.Scanner;

public class CalculateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::valueOf).toArray();
        double f1 = Math.pow((Math.pow(numbers[0], 2) + Math.pow(numbers[1], 2)) /
                (Math.pow(numbers[0], 2) - Math.pow(numbers[1], 2)),
                (numbers[0] + numbers[1] + numbers[2]) / Math.sqrt(numbers[2]));
        double f2 = Math.pow(Math.pow(numbers[0], 2) + Math.pow(numbers[1], 2) - Math.pow(numbers[2], 3), numbers[0] - numbers[1]);
        double diff = Math.abs(avg(numbers[0], numbers[1], numbers[2]) - avg(f1, f2));
        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, diff);
    }
    private static double avg(double a, double b, double c){
        return (a + b + c) / 3.0;
    }

    private static double avg(double a, double b){
        return (a + b) / 2.0;
    }
}
