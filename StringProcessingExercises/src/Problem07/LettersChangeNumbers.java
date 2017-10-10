package Problem07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LettersChangeNumbers {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split("\\s+");
        double result = 0;
        for (String word : inputs) {
            result += calculateString(word);
        }
        System.out.printf("%.2f", result);
    }
    private static double calculateString(String word){
        char firstCharacter = word.charAt(0);
        int firstCharacterPosition = getAlphabetPosition(firstCharacter);
        double number = Double.parseDouble(word.substring(1, word.length() - 1));
        char lastCharacter = word.charAt(word.length() - 1);
        int lastCharacterPosition = getAlphabetPosition(lastCharacter);
        if (Character.isUpperCase(firstCharacter))
            number /= firstCharacterPosition;
        else
            number *= firstCharacterPosition;

        if (Character.isUpperCase(lastCharacter))
            number -= lastCharacterPosition;
        else
            number += lastCharacterPosition;

        return number;
    }

    private static int getAlphabetPosition(char ch){
        if (Character.isUpperCase(ch))
            return (ch - 'A') + 1;
        else
            return (ch - 'a') + 1;
    }
}