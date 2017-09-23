package Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumSumOfSubMatrix {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] matrixParams = Arrays.stream(reader.readLine().split("[ ,]+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[matrixParams[0]][matrixParams[1]];
        int maxSum = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length; row++) {
            int[] elements = Arrays.stream(reader.readLine().split("[, ]+")).mapToInt(Integer::valueOf).toArray();
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = elements[col];
            }
        }
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[0].length - 1; col++) {
                int currentSum = matrix[row][col] +
                                 matrix[row][col + 1] +
                                 matrix[row + 1][col] +
                                 matrix[row + 1][col + 1];
                if (currentSum > maxSum){
                    bestCol = col;
                    bestRow = row;
                    maxSum = currentSum;
                }
            }
        }
        System.out.println(matrix[bestRow][bestCol] + " " + matrix[bestRow][bestCol + 1]);
        System.out.println(matrix[bestRow + 1][bestCol] + " " + matrix[bestRow + 1][bestCol + 1]);
        System.out.println(maxSum);
    }
}
