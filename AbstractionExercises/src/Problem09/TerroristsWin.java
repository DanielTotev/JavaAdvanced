package Problem09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerroristsWin {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("\\|([^|]+?)\\|");
        StringBuilder input = new StringBuilder(reader.readLine());
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            int power = calculateBombPower(matcher.group(1));
            int firstDashIndex = input.indexOf("|");
            int nextDashIndex = input.indexOf("|", firstDashIndex + 1);
            int startIndex = Math.max(0, firstDashIndex - power);
            int endIndex = Math.min(input.length() - 1, nextDashIndex + power);
            input.replace(startIndex, endIndex + 1, generateReplacement((endIndex - startIndex) + 1));
        }
        System.out.println(input.toString());
    }
    private static int calculateBombPower(String bomb){
        int characterSum = 0;
        for (int i = 0; i < bomb.length(); i++) {
            characterSum += bomb.charAt(i);
        }
        return characterSum % 10;
    }
    private static String generateReplacement(int dotCount){
        StringBuilder replacement = new StringBuilder();
        for (int i = 0; i < dotCount; i++) {
            replacement.append(".");
        }
        return replacement.toString();
    }
}
