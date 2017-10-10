package Problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiagonalDifference {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        int[][] matrix = new int[n][n];
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = arr[col];
            }
        }
        int primaryDiagonalSum = 0;
        int secondaryDiagonal = 0;
        for (int i = 0; i < n; i++) {
            primaryDiagonalSum += matrix[i][i];
            secondaryDiagonal += matrix[i][n - i - 1];
        }
        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonal));
    }

}
