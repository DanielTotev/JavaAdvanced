package Problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ImplementBinarySearchUsingRecursion {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int number = Integer.parseInt(reader.readLine());
        System.out.println(binarySearch(numbers, number, 0, numbers.length - 1));
    }
    private static int binarySearch(int[] numbers, int searchedNumber, int start, int end){
        if (start <= end){
            int middle = (start + end) / 2;
            if (searchedNumber < numbers[middle]){
                return binarySearch(numbers, searchedNumber, start, middle - 1);
            }else if (searchedNumber > numbers[middle]){
                return binarySearch(numbers, searchedNumber, middle + 1, end);
            }else {
                return middle;
            }
        }
        return -1;
    }
}
