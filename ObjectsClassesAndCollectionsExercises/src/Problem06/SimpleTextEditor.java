package Problem06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class SimpleTextEditor {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> backup = new ArrayDeque<>();
        int numberOfOperations = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfOperations; i++) {
            String[] cmdParams = reader.readLine().split("\\s+");
            int commandType = Integer.parseInt(cmdParams[0]);
            switch (commandType){
                case 1:
                    backup.push(text.toString());
                    text.append(cmdParams[1]);
                    break;
                case 2:
                    int deleteCount = Integer.parseInt(cmdParams[1]);
                    backup.push(text.toString());
                    for (int j = 0; j < deleteCount; j++) {
                        text.deleteCharAt(text.length() - 1);
                    }
                    break;
                case 3:
                    int index = Integer.parseInt(cmdParams[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case 4:
                    text = new StringBuilder(backup.pop());
                    break;
            }
        }
    }
}
