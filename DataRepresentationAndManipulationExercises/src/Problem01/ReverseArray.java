package Problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        reverse(numbers, 0, numbers.length - 1);
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
    private static void reverse(int[] numbers, int i, int j){
        if (i < j){
            int tmp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = tmp;
            reverse(numbers, ++i, --j);
        }
    }
}
