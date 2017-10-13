package Problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Function<int[], Integer> findSmallestElement = x -> {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < x.length; i++) {
                if (x[i] < min)
                    min = x[i];
            }
            return min;
        };
        System.out.println(findSmallestElement.apply(numbers));
    }
}
