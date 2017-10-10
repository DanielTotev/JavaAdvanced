package Problem05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximalSum {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] matrixParams = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int[][] matrix = new int[matrixParams[0]][matrixParams[1]];
        for (int row = 0; row < matrix.length; row++) {
            int[] elements = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = elements[col];
            }
        }
        int maxSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[0].length - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                         + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                         + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (sum > maxSum){
                    bestRow = row;
                    bestCol = col;
                    maxSum = sum;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        System.out.println(matrix[bestRow][bestCol] + " " + matrix[bestRow][bestCol + 1] + " " + matrix[bestRow][bestCol + 2]);
        System.out.println(matrix[bestRow + 1][bestCol] + " " + matrix[bestRow + 1][bestCol + 1] + " " + matrix[bestRow + 1][bestCol + 2]);
        System.out.println(matrix[bestRow + 2][bestCol] + " " + matrix[bestRow + 2][bestCol + 1] + " " + matrix[bestRow + 2][bestCol + 2]);
    }
}
