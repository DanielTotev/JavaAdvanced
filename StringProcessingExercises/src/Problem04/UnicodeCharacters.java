package Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnicodeCharacters {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        for (int i = 0; i < word.length(); i++) {
            System.out.print( "\\u" + Integer.toHexString(word.charAt(i) | 0x10000).substring(1) );
        }
    }
}
