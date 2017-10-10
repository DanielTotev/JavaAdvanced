package Problem07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String name = reader.readLine();
            if (name.equals("END")){
                break;
            }
            if (Pattern.matches("^[\\w-]{3,16}$", name))
                System.out.println("valid");
            else
                System.out.println("invalid");
        }
    }
}
