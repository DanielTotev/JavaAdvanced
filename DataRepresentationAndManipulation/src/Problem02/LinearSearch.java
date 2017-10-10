package Problem02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int number = Integer.valueOf(reader.readLine());
        System.out.println(search(array, number));
    }
    private static int search(int[] array, int number){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number)
                return i;
        }
        return -1;
    }
}
