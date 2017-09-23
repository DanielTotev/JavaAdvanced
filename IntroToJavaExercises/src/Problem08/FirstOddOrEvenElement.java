package Problem08;

import java.util.Arrays;
import java.util.Scanner;


public class FirstOddOrEvenElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[] cmdParams = scanner.nextLine().split("\\s+");
        int limit = Integer.parseInt(cmdParams[1]);
        Arrays.stream(numbers)
                .filter(cmdParams[2].equals("even") ? n -> Math.abs(n) % 2 == 0 : n -> Math.abs(n) % 2 == 1)
                .limit(limit)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}
