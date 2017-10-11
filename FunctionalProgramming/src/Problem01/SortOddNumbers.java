package Problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortOddNumbers {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbersAsStrings = reader.readLine().split(", ");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numbersAsStrings.length; i++) {
            numbers.add(Integer.parseInt(numbersAsStrings[i]));
        }
        numbers.removeIf(x -> x % 2 != 0);
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers.toString().replace("[", "")
        .replace("]", ""));
    }
}
