package Problem06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MagicExchangeableWords {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split("\\s+");
        String possiblyShorterWord = words[1].length() <= words[0].length() ? words[1] : words[0];
        String possiblyLongerWord = words[0].length() >= words[1].length() ? words[0] : words[1];
        boolean areExchangeable = true;
        HashMap<Character, Character> letters = new HashMap<>();
        for (int i = 0; i < possiblyShorterWord.length(); i++) {
            if (!letters.containsKey(possiblyLongerWord.charAt(i))){
                letters.put(possiblyLongerWord.charAt(i), possiblyShorterWord.charAt(i));
            }else {
                if (letters.get(possiblyLongerWord.charAt(i)) != possiblyShorterWord.charAt(i)){
                    System.out.println("false");
                    areExchangeable = false;
                    break;
                }
            }
        }
        if (areExchangeable) {
            for (int i = possiblyShorterWord.length(); i < possiblyLongerWord.length(); i++) {
                if (!letters.containsKey(possiblyLongerWord.charAt(i))) {
                    System.out.println("false");
                    areExchangeable = false;
                    break;
                }
            }
        }
        if (areExchangeable)
            System.out.println("true");
    }
}
