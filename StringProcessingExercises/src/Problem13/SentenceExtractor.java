package Problem13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceExtractor {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        String text = reader.readLine();
        Pattern sentencePattern = Pattern.compile("[^.!?]+?\\b" + word + "\\b[^.!?]+?[.!?]");
        Matcher matcher = sentencePattern.matcher(text);
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
