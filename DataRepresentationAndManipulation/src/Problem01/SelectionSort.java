package Problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < numbers.length; i++) {
            int minimalElementIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[minimalElementIndex] > numbers[j])
                    minimalElementIndex = j;
            }
            swapElements(numbers, i, minimalElementIndex);
        }
        System.out.println(Arrays.toString(numbers)
                .replace(",", "")
                .replace("[", "")
                .replace("]", ""));
    }
    private static void swapElements(int[] array, int firsIndex, int secondIndex){
        int temp = array[firsIndex];
        array[firsIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
