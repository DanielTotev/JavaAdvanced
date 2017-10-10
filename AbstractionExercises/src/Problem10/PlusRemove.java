package Problem10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PlusRemove {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<char[]> originalMatrix = new ArrayList<>();
        List<char[]> copyMatrix = new ArrayList<>();
        while (true){
            String input = reader.readLine();
            if (input.equalsIgnoreCase("END")){
                break;
            }
            originalMatrix.add(input.toCharArray());
            copyMatrix.add(input.toUpperCase().toCharArray());
        }
        manipulateMatrix(originalMatrix, copyMatrix);
        printMatrix(originalMatrix);
    }

    private static void printMatrix(List<char[]> originalMatrix) {
        for (char[] anOriginalMatrix : originalMatrix) {
            System.out.println(String.valueOf(anOriginalMatrix).replace("\0", ""));
        }
    }

    private static void manipulateMatrix(List<char[]> originalMatrix, List<char[]> copyMatrix) {
        for (int row = 0; row < originalMatrix.size() - 2; row++) {
            for (int col = 0; col < originalMatrix.get(row).length; col++) {
                try{
                    char a = copyMatrix.get(row)[col];
                    char b = copyMatrix.get(row + 1)[col - 1];
                    char c = copyMatrix.get(row + 1)[col];
                    char d = copyMatrix.get(row + 1)[col + 1];
                    char e = copyMatrix.get(row + 2)[col];

                    if (a == b && b == c && c == d && d == e){
                        originalMatrix.get(row)[col] = '\0';
                        originalMatrix.get(row + 1)[col - 1] = '\0';
                        originalMatrix.get(row + 1)[col] = '\0';
                        originalMatrix.get(row + 1)[col + 1] = '\0';
                        originalMatrix.get(row + 2)[col] = '\0';
                    }

                }catch (IndexOutOfBoundsException ex){ }
            }
        }
    }
}
