package Problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseTags {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        while (true){
            int openingTagIndex = text.indexOf("<upcase>");
            int closingTagIndex = text.indexOf("</upcase>");
            if (openingTagIndex < 0 || closingTagIndex < 0){
                break;
            }
            String textToReplace = text.substring(openingTagIndex + "<upcase>".length(), closingTagIndex);
            text = text.replace("<upcase>" + textToReplace + "</upcase>", textToReplace.toUpperCase());
        }
        System.out.println(text);
    }
}
