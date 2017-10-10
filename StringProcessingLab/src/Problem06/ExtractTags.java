package Problem06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractTags {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern tagPattern = Pattern.compile("<.+?>");
        while (true){
            String input = reader.readLine();
            if (input.equals("END")){
                break;
            }
            Matcher matcher = tagPattern.matcher(input);
            while (matcher.find()){
                System.out.println(matcher.group());
            }
        }
    }
}
