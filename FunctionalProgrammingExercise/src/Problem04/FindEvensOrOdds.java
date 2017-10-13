package Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String criteria = reader.readLine();
        Predicate<Integer> checkIfMatch = criteria.equals("odd") ? x -> x % 2 != 0 : x -> x % 2 == 0;
        for (int i = numbers[0]; i <= numbers[1] ; i++) {
            if (checkIfMatch.test(i))
                System.out.print(i + " ");
        }

    }
}
