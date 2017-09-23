package Problem10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XBits {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] binaries = new String[8];
        for (int i = 0; i < 8; i++) {
            int number = Integer.valueOf(reader.readLine());
            String binaryRepresentation = String.format("%32s", Integer.toBinaryString(number))
                    .replace(' ', '0');
            binaries[i] = binaryRepresentation;
        }
        int xCounter = 0;
        for (int i = 0; i < binaries.length - 2; i++) {
            for (int j = 0; j < binaries[i].length() - 2; j++) {
                String firstLineCharacters = binaries[i].charAt(j) + "" + binaries[i].charAt(j + 1) + "" + binaries[i].charAt(j + 2);
                String secondLineCharacters = binaries[i + 1].charAt(j) + "" + binaries[i + 1].charAt(j + 1) + "" + binaries[i + 1].charAt(j + 2);
                String thirdLineCharacters = binaries[i + 2].charAt(j) + "" + binaries[i + 2].charAt(j + 1) + "" + binaries[i + 2].charAt(j + 2);
                if (firstLineCharacters.equals("101") && secondLineCharacters.equals("010") && thirdLineCharacters.equals("101"))
                    xCounter++;
            }
        }
        System.out.println(xCounter);
    }
}
