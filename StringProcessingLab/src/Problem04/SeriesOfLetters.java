package Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeriesOfLetters {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StringBuilder output = new StringBuilder();
        int index = 0;
        int state = 0;
        char prev = '\0';
        while (index < input.length()){
            switch (state){
                case 0:
                    prev = input.charAt(index);
                    state = 1;
                    break;
                case 1:
                    output.append(prev);
                    if (prev == input.charAt(index))
                        state = 2;
                    prev = input.charAt(index);
                    break;
                case 2://equal chars
                    if (input.charAt(index) != prev){
                        state = 1;
                    }
                    prev = input.charAt(index);
                    break;
            }
            index++;
        }
        if(input.charAt(index - 2) != prev)
            output.append(prev);
        System.out.println(output);
    }
}
