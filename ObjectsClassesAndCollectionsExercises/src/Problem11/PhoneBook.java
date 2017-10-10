package Problem11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String>  phoneBook = new HashMap<>();
        while (true){
            String draft = reader.readLine();
            if (draft.equals("search")){
                break;
            }
            String[] draftTokens = draft.split("-");
            phoneBook.put(draftTokens[0], draftTokens[1]);
        }
        while (true){
            String name = reader.readLine();
            if (name.equals("stop")){
                break;
            }
            String phoneNumber = phoneBook.get(name);
            if (phoneNumber == null){
                System.out.printf("Contact %s does not exist." + System.lineSeparator(), name);
                continue;
            }
            System.out.println(name + " -> " + phoneNumber);
        }
    }
}
