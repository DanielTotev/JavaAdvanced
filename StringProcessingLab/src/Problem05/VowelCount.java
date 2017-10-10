package Problem05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelCount {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int vowelsCount = 0;
        Pattern vowelPattern = Pattern.compile("[aeiouyAEIOUY]");
        Matcher matcher = vowelPattern.matcher(input);
        while (matcher.find()){
            vowelsCount++;
        }
        System.out.println("Vowels: " + vowelsCount);
    }
}
