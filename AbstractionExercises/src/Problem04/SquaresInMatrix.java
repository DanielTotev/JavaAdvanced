package Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SquaresInMatrix {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] matrixParams = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[matrixParams[0]][matrixParams[1]];
        for (int row = 0; row < matrix.length; row++) {
            String[] arr = reader.readLine().split("\\s+");
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = arr[col];
            }
        }
        System.out.println(findEqualSquares(matrix));
    }
    private static int findEqualSquares(String[][] matrix){
        int count = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[0].length - 1; col++) {
                if (matrix[row][col].equals(matrix[row][col + 1]) && matrix[row][col].equals(matrix[row + 1][col])
                        && matrix[row][col].equals(matrix[row + 1][col + 1]))
                    count++;
            }
        }
        return count;
    }
}
