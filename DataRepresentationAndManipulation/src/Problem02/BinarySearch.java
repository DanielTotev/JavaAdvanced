package Problem02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int number = Integer.valueOf(reader.readLine());
        Arrays.sort(numbers);
        System.out.println(search(numbers, 0, numbers.length - 1, number));
    }
    private static int search(int[] array, int start, int end, int element){
        while (end >= start){
            int middle = (end + start) / 2;
            if (array[middle] > element)
                end = middle - 1;
            else if (array[middle] < element)
                start = middle + 1;
            else if (array[middle] == element)
                return middle;
        }
        return -1;
    }
}
