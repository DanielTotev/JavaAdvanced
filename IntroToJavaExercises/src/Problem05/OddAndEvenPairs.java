package Problem05;

import java.util.Arrays;
import java.util.Scanner;

public class OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .toArray();
        if (numbers.length % 2 != 0){
            System.out.println("invalid length");
            return;
        }
        String pairStatus;
        for (int i = 0; i <= numbers.length - 2; i+= 2) {
            if (numbers[i] % 2 == 0 && numbers[i + 1] % 2 == 0){
                pairStatus = "both are even";
            }else if (numbers[i] % 2 == 1 && numbers[i + 1] % 2 == 1){
                pairStatus = "both are odd";
            }else {
                pairStatus = "different";
            }
            System.out.println(numbers[i] + ", " + numbers[i + 1] + " -> " + pairStatus);
        }
    }
}
