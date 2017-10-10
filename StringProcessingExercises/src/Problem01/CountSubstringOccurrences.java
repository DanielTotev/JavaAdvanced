package Problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CountSubstringOccurrences {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().toLowerCase();
        String word = reader.readLine().toLowerCase();
        int counter = 0;
        int wordIndex = input.indexOf(word);
        while (wordIndex >= 0){
            counter++;
            wordIndex = input.indexOf(word, wordIndex + 1);
        }
        System.out.println(counter);
    }
}
