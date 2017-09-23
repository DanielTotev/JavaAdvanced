package Problem02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfInputs = Integer.parseInt(reader.readLine());
        int[] encryptedNames = new int[numberOfInputs];
        for (int i = 0; i < numberOfInputs; i++) {
            String currentName = reader.readLine();
            encryptedNames[i] = encrypt(currentName);
        }
        Arrays.sort(encryptedNames);
        for (int encryptedName : encryptedNames) {
            System.out.println(encryptedName);
        }

    }
    private static int encrypt(String name){
        String vowels = "aeiouAEIOU";
        int sum = 0;
        for (int i = 0; i < name.length(); i++) {
            if (vowels.contains(String.valueOf(name.charAt(i)))){
                sum += name.charAt(i) * name.length();
            }else {
                sum += name.charAt(i) / name.length();
            }
        }
        return sum;
    }
}
