package Problem05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PascalTriangle {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int height = Integer.parseInt(reader.readLine());
        BigInteger[][] pascal = new BigInteger[height][];
        for (int i = 0; i < pascal.length; i++) {
            pascal[i] = new BigInteger[i + 1];
            pascal[i][0] = new BigInteger("1");
            pascal[i][pascal[i].length - 1] = new BigInteger("1");
            if (i > 1) {
                for (int j = 1; j <= pascal[i].length - 2; j++) {
                    pascal[i][j] = pascal[i - 1][j].add(pascal[i - 1][j - 1]);
                }
            }
        }
        for (int row  = 0; row < pascal.length ; row++) {
            for (int col = 0; col < pascal[row].length; col++) {
                System.out.print(pascal[row][col] + " ");
            }
            System.out.println();
        }
    }
}
