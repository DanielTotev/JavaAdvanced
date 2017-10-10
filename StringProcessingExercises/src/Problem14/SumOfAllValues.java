package Problem14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = reader.readLine();
        Pattern keyPattern = Pattern.compile("^([a-zA-Z_]+)(?=\\d+).+(?<=\\d)([a-zA-Z_]+)");
        Matcher keyMatcher = keyPattern.matcher(key);
        if (!keyMatcher.find()){
            System.out.println("<p>A key is missing</p>");
            return;
        }
        String startKey = keyMatcher.group(1);
        String endKey = keyMatcher.group(2);
        String text = reader.readLine();
        Pattern findNumberPattern = Pattern.compile(startKey + "(.+?)" + endKey);
        Matcher numberMatcher = findNumberPattern.matcher(text);
        double sum = 0.0;
        while (numberMatcher.find()){
            sum += tryParse(numberMatcher.group(1));
        }
        if (sum == 0)
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        else if (sum == (int) sum){
            System.out.printf("<p>The total value is: <em>%d</em></p>" + System.lineSeparator(), (int)sum);
        }else {
            System.out.printf("<p>The total value is: <em>%.2f</em></p>" + System.lineSeparator(), sum);
        }
    }
    private static double tryParse(String possibleNumber){
        try {
            return Double.parseDouble(possibleNumber);
        }catch (NumberFormatException ex){
            return 0;
        }
    }
}
