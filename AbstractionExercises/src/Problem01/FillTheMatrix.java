package Problem01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FillTheMatrix {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] params = reader.readLine().split(", ");
        int n = Integer.parseInt(params[0]);
        String type = params[1];
        int[][] matrix = new int[n][n];
        switch (type){
            case "A":
                matrix = fillMatrixTypeA(n);
                break;
            case "B":
                matrix = fillMatrixTypeB(n);
                break;
        }
        printMatrix(matrix);
    }
    private static int[][] fillMatrixTypeA(int n){
        int[][] matrix = new int[n][n];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][0] = row + 1;
            for (int col = 1; col < matrix[0].length; col++) {
                matrix[row][col] = matrix[row][col - 1] + n;
            }
        }
        return matrix;
    }
    private static int[][] fillMatrixTypeB(int n){
        int[][] matrix  = new int[n][n];
        int currentNumber = 1;
        for (int col = 0; col < matrix.length; col++)
        {
            if (col % 2 == 0)
            {
                for (int row = 0; row < matrix.length; row++)
                {
                    matrix[row][col] = currentNumber;
                    currentNumber++;
                }
            }
            else
            {
                for (int row = matrix.length - 1; row >= 0; row--)
                {
                    matrix[row][col] = currentNumber;
                    currentNumber++;
                }
            }
        }
        return matrix;
    }
    private static void printMatrix(int[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    private static void reverseArray(int[] arr){
        for(int i = 0; i < arr.length / 2; i++)
        {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
}
