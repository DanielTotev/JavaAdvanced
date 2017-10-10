import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int degrees = Integer.parseInt(line.substring(line.indexOf('(') + 1,line.indexOf(')')));
        List<String> inputs = new ArrayList<>();
        int columnCount = 0;
        while (true){
            String input = scanner.nextLine();
            if (input.equals("END"))
                break;
            if (input.length() > columnCount)
                columnCount = input.length();
            inputs.add(input);
        }
        char[][] matrix = new char[inputs.size()][columnCount];
        for (int i = 0; i < matrix.length; i++) {
            char[] arr = inputs.get(i).toCharArray();
            for (int j = 0; j < arr.length; j++) {
                matrix[i][j] = arr[j];
            }
        }
        for (int i = 0; i < degrees / 90; i++) {
            matrix = rotateMatrix(matrix);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "");
            }
            System.out.println();
        }
    }

    private static char[][] rotateMatrix(char[][] matrix) {
        char[][] rotated = new char[matrix[0].length][matrix.length];

        for (int row = matrix.length - 1; row >= 0; row--) {
            int destCol = matrix.length - 1 - row;
            int destRow = 0;
            for (int col = 0; col < matrix[0].length; col++) {
                rotated[destRow++][destCol] = matrix[row][col];
            }
        }

        return rotated;
    }
}
