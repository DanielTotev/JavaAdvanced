package Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class CombinationsCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        BigInteger pascalTriangleCombinations = calculateFactorial(n).divide(calculateFactorial(n - k).multiply(calculateFactorial(k)));
        System.out.println(pascalTriangleCombinations);
    }
    private static BigInteger calculateFactorial(int number){
        if (number < 2){
            return new BigInteger("1");
        }
        return new BigInteger(String.valueOf(number)).multiply(
                calculateFactorial(number - 1));
    }
}
