package Problem10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Map<Character, Integer> counter = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (!counter.containsKey(input.charAt(i))){
                counter.put(input.charAt(i), 0);
            }
            counter.put(input.charAt(i), counter.get(input.charAt(i)) + 1);
        }
        for (Character character : counter.keySet()) {
            System.out.println(character + ": " + counter.get(character) + " time/s");
        }
    }
}
