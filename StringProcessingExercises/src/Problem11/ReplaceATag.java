package Problem11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceATag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("<a\\s+href=(\"[^>]+\")>([^>]+)</a>");
        String line = reader.readLine();
        StringBuilder text = new StringBuilder();
        while (!line.equals("END")) {
            text.append(line);
            text.append("\r\n");
            line = reader.readLine();
        }
        String result = text.toString();
        Matcher matcher = pattern.matcher(text.toString());
        while (matcher.find()) {
            String replacement = String.format("[URL href=%1s]%2s[/URL]", matcher.group(1), matcher.group(2));
            result = result.replace(matcher.group(0), replacement);
        }
        System.out.println(result);
    }
}