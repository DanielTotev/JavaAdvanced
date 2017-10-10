package Problem08;

import java.util.regex.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatchPhoneNumbers {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("([A-Z][a-zA-Z]*)[^a-zA-Z+]*?(?=\\\\+|[0-9]{2})([0-9+]?[0-9][0-9/(). -]*[0-9])");
        StringBuilder output = new StringBuilder();
        output.append("<ol>");
        while (true){
            String line = reader.readLine();
            if (line.equals("END")){
                break;
            }
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                String name = matcher.group(1);
                String number = matcher.group(2).replaceAll("[()\\/\\.\\- ]","");
                String partialResult = String.format("<li><b>%s:</b> %s</li>", name, number);
                output.append(partialResult);
            }
        }
        output.append("</ol>");
        System.out.println(output);
    }
}
