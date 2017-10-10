package Problem15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ValidUserNames {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNames = reader.readLine().split("[ \\/\\\\)(]+");
        String validNamePattern = "[a-zA-Z][a-zA-Z0-9_]{2,25}";
        List<String> validNames = new ArrayList<>();
        for (String name : inputNames) {
            if (Pattern.matches(validNamePattern, name))
                validNames.add(name);
        }
        int firstElementIndex = getBiggestLength(validNames);
        System.out.println(validNames.get(firstElementIndex));
        System.out.println(validNames.get(firstElementIndex + 1));
    }
    private static int getBiggestLength(List<String> names){
        int maxLength = 0;
        int startIndex = 0;
        for (int i = 0; i < names.size() - 1; i++) {
            int currentLength = names.get(i).length() + names.get(i + 1).length();
            if (currentLength > maxLength){
                maxLength = currentLength;
                startIndex = i;
            }
        }


        return startIndex;
    }
}
