package Problem07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindTheMissingNumber {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfElements = Integer.parseInt(reader.readLine());
        int[] numbers = new int[numberOfElements];
        numbers = Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(numbers);
        System.out.println(findMissingElement(numbers));
    }
    private static int findMissingElement(int[] numbers){
        int missingNumber  = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] + 1 != numbers[i + 1]){
                missingNumber = numbers[i] + 1;
            }
        }
        return missingNumber;
    }
}
