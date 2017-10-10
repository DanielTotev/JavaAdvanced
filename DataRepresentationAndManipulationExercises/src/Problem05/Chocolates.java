package Problem05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Chocolates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        int[] chocolates = Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(chocolates);
        int numberOfStudents = Integer.parseInt(reader.readLine());
        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < chocolates.length - numberOfStudents; i++) {
            int currentDifference = chocolates[i + (numberOfStudents - 1)] - chocolates[i];
            if (currentDifference < minDifference){
                minDifference = currentDifference;
            }
        }
        System.out.println("Min Difference is " + minDifference + ".");
    }
}
