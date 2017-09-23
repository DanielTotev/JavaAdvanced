package Problem09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ByteParty {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }
        String command = reader.readLine();
        while (!command.equals("party over")){
            String[] cmdParams = command.split("\\s+");
            int action = Integer.parseInt(cmdParams[0]);
            int position = Integer.valueOf(cmdParams[1]);
            switch (action){
                case -1:
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] ^ (1 << position);
                    }
                    break;
                case 0:
                    int mask = ~(1 << position);
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] & mask;
                    }
                    break;
                case 1:
                    int maskOne = (1 << position);
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] | maskOne;
                    }
                    break;
            }
            command = reader.readLine();
        }
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
