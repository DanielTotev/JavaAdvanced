package Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFactorial {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        System.out.println(calculateFactorial(n));
    }
    private static long calculateFactorial(int n){
        if (n <= 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }
}
