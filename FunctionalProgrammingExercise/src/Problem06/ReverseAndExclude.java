package Problem06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbersAsString = reader.readLine().split("\\s+");
        int divider = Integer.parseInt(reader.readLine());
        List<Integer> numbers = new LinkedList<>();
        for (String aNumbersAsString : numbersAsString) {
            numbers.add(Integer.parseInt(aNumbersAsString));
        }
        Collections.reverse(numbers);
        numbers.removeIf(x -> x % divider == 0);
        numbers.forEach(x -> System.out.print(x + " "));
    }
}
