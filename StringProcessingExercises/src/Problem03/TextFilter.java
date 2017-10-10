package Problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextFilter {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] bannedWords = reader.readLine().split(", ");
        String text = reader.readLine();
        for (String bannedWord : bannedWords) {
            text = text.replace(bannedWord, generateReplacement(bannedWord));
        }
        System.out.println(text);
    }
    private static String generateReplacement(String word){
        StringBuilder replacement = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            replacement.append("*");
        }
        return replacement.toString();
    }
}
