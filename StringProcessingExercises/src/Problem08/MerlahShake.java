package Problem08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MerlahShake {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder word = new StringBuilder(reader.readLine());
        StringBuilder pattern = new StringBuilder(reader.readLine());
        int firstOccurrenceIndex = word.indexOf(pattern.toString());
        int lastOccurrenceIndex = word.lastIndexOf(pattern.toString());
        while (firstOccurrenceIndex >= 0 && lastOccurrenceIndex >= 0 && pattern.length() > 0 ){
            if (firstOccurrenceIndex == lastOccurrenceIndex){
                break;
            }
            word.delete(firstOccurrenceIndex, firstOccurrenceIndex + pattern.length());
            lastOccurrenceIndex = word.lastIndexOf(pattern.toString());
            if (lastOccurrenceIndex < 0){
                break;
            }
            word.delete(lastOccurrenceIndex, lastOccurrenceIndex + pattern.length());
            System.out.println("Shaked it.");
            pattern.deleteCharAt(pattern.length() / 2);
            firstOccurrenceIndex = word.indexOf(pattern.toString());
            lastOccurrenceIndex = word.lastIndexOf(pattern.toString());
        }
        System.out.println("No shake.");
        System.out.println(word.toString());
    }
}
