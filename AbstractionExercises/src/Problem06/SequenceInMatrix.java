package Problem06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SequenceInMatrix {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] matrixParams = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[matrixParams[0]][matrixParams[1]];
        for (int row = 0; row < matrix.length; row++) {
            String[] items = reader.readLine().split("\\s+");
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = items[col];
            }
        }
        List<String> result = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length ; col++) {
                checkDiagonal(matrix, row, col, result);
                checkLine(matrix, row, col, result);
                checkColumn(matrix, row, col, result);
            }
        }
        System.out.println(String.join(", ", result));
    }

    private static void checkColumn(String[][] matrix, int row, int col, List<String> result) {
        List<String> tempResult = new ArrayList<>();
        tempResult.add(matrix[row][col]);
        for (int i = row + 1; i < matrix.length; i++) {
            if (matrix[row][col].equals(matrix[i][col])){
                tempResult.add(matrix[row][col]);
            }else {
                break;
            }
        }
        if (tempResult.size() >= result.size()){
            result.clear();
            Collections.addAll(result, String.join(" ",tempResult).split(" "));
        }
    }

    private static void checkLine(String[][] matrix, int row, int col, List<String> result) {
        List<String> tempResult = new ArrayList<>();
        tempResult.add(matrix[row][col]);
        for (int i = col; i < matrix[row].length - 1; i++) {
            if (matrix[row][i].equals(matrix[row][i + 1])){
                tempResult.add(matrix[row][i]);
            }else {
                break;
            }
        }
        if (tempResult.size() >= result.size()){
            result.clear();
            Collections.addAll(result, String.join(" ",tempResult).split(" "));
        }
    }

    private static void checkDiagonal(String[][] matrix, int row, int col, List<String> result) {
        List<String> tempResult = new ArrayList<>();
        tempResult.add(matrix[row][col]);
        int currentCol  = col + 1;
        for (int i = row + 1; i < matrix.length; i++) {
            try {

                if (matrix[i][currentCol].equalsIgnoreCase(matrix[row][col])) {
                    tempResult.add(matrix[i][currentCol]);
                } else {
                    break;
                }
                currentCol++;
            }catch (IndexOutOfBoundsException ex) {break;}
        }
        if (tempResult.size() >= result.size()){
            result.clear();
            Collections.addAll(result, String.join(" ",tempResult).split(" "));
        }
    }
}
