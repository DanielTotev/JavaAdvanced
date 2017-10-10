package Problem02;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                char firstAndLastLetter = (char) ('a' + row);
                char middleLetter = (char) ('a' + row + col);
                matrix[row][col] = firstAndLastLetter + "" + middleLetter + firstAndLastLetter;
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
