package Problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split("\\s+");
        Predicate<String> startsWithCapitalLetter = s -> Character.isUpperCase(s.charAt(0));
        List<String> capitalLetterWords = new ArrayList<>();
        for (String word : words) {
            if (startsWithCapitalLetter.test(word)){
                capitalLetterWords.add(word);
            }
        }
        System.out.println(capitalLetterWords.size());
        capitalLetterWords.forEach(s -> System.out.println(s));
    }
}
