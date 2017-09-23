package Problem13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BlurFilter {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int blurAmount = Integer.valueOf(reader.readLine());
        int[] matrixParams = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] matrix = new int[matrixParams[0]][matrixParams[1]];
        for (int i = 0; i < matrixParams[0]; i++) {
            int[] arr = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < arr.length; j++) {
                matrix[i][j] = arr[j];
            }
        }
        int[] blurCoordinates = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        matrix[blurCoordinates[0]][blurCoordinates[1]] += blurAmount;
        matrix[blurCoordinates[0]][blurCoordinates[1] + 1] += blurAmount;
        matrix[blurCoordinates[0]][blurCoordinates[1] - 1] += blurAmount;
        matrix[blurCoordinates[0] + 1][blurCoordinates[1]] += blurAmount;
        matrix[blurCoordinates[0] + 1][blurCoordinates[1] + 1] += blurAmount;
        matrix[blurCoordinates[0] + 1][blurCoordinates[1] - 1] += blurAmount;
        matrix[blurCoordinates[0] - 1][blurCoordinates[1]] += blurAmount;
        matrix[blurCoordinates[0] - 1][blurCoordinates[1] + 1] += blurAmount;
        matrix[blurCoordinates[0] - 1][blurCoordinates[1] - 1] += blurAmount;
        for (int i = 0; i < matrixParams[0]; i++) {
            for (int j = 0; j < matrixParams[1]; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
