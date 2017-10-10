package Problem10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String phoneNumber = reader.readLine();
            if (phoneNumber.equals("end")){
                break;
            }
            if (Pattern.matches("^\\+359([ -])2\\1\\d{3}\\1\\d{4}$", phoneNumber))
                System.out.println(phoneNumber);
        }
    }
}
