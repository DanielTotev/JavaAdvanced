package Problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumMatrixElements {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] matrixPrams = Arrays.stream(reader.readLine().split("[, ]+")).mapToInt(Integer::valueOf).toArray();
        int[][] matrix = new int[matrixPrams[0]][matrixPrams[1]];
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            int[] elements = Arrays.stream(reader.readLine().split("[, ]+")).mapToInt(Integer::valueOf).toArray();
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = elements[col];
                sum += elements[col];
            }
        }
        System.out.println(matrixPrams[0]);
        System.out.println(matrixPrams[1]);
        System.out.println(sum);
    }
}
