package Problem05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Palindromes {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] possiblePalindromes = reader.readLine().split("[ ,.?!]+");
        Set<String> palindromes = new TreeSet<>();
        for (String possiblePalindrome : possiblePalindromes) {
            if (isPalindrome(possiblePalindrome))
                palindromes.add(possiblePalindrome);
        }
        System.out.println(palindromes.toString());
    }
    private static boolean isPalindrome(String word){
        return word.equals(reverse(word));
    }

    private static String reverse(String word){
        StringBuilder reversed = new StringBuilder(word.length());
        for (int i = word.length() - 1; i >= 0 ; i--) {
            reversed.append(word.charAt(i));
        }
        return reversed.toString();
    }
}
