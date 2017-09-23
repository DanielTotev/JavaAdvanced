import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryingOutSth {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int row = Integer.valueOf(reader.readLine());
        int col = Integer.valueOf(reader.readLine());
        int[][] matrix = new int[row][col];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.valueOf(reader.readLine());
            }
        }
    }
}
