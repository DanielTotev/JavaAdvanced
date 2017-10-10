package Problem08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixShuffling {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] matrixParams = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        String[][] matrix = new String[matrixParams[0]][matrixParams[1]];
        for (int row = 0; row < matrix.length; row++) {
            String[] tokens = reader.readLine().split("\\s+");
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = tokens[col];
            }
        }
        while (true){
            String command = reader.readLine();
            if (command.equals("END")) {
                break;
            }
            String[] cmdParams = command.split("\\s+");
            if (!cmdParams[0].equals("swap") || cmdParams.length != 5){
                System.out.println("Invalid input!");
                continue;
            }
            int firstElementRow = Integer.parseInt(cmdParams[1]);
            int firstElementCol = Integer.parseInt(cmdParams[2]);
            int secondElementRow = Integer.parseInt(cmdParams[3]);
            int secondElementCol = Integer.parseInt(cmdParams[4]);
            try {
                String temp = matrix[firstElementRow][firstElementCol];
                matrix[firstElementRow][firstElementCol] = matrix[secondElementRow][secondElementCol];
                matrix[secondElementRow][secondElementCol] = temp;
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[0].length; col++) {
                        System.out.print(matrix[row][col] + " ");
                    }
                    System.out.println();
                }
            }catch (IndexOutOfBoundsException ex){
                System.out.println("Invalid input!");
            }
        }
    }
}
