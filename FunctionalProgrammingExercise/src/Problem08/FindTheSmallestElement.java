package Problem08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Function<int[], Integer> findSmallestElementIndex = x ->{
            int minElement = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < x.length; i++) {
                if (x[i] <= minElement){
                    minElement = x[i];
                    minIndex = i;
                }
            }
            return minIndex;
        };
        System.out.println(findSmallestElementIndex.apply(numbers));
    }
}
