package Problem02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbersAsStrings = reader.readLine().split(", ");
        System.out.println("Count = " + numbersAsStrings.length);
        Function<String, Integer> parse = x -> Integer.parseInt(x);
        int sum = 0;
        for (String number : numbersAsStrings) {
            sum += parse.apply(number);
        }
        System.out.println("Sum = " + sum);
    }
}
