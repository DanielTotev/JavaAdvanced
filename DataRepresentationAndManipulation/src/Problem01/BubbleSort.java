package Problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]){
                    swapElements(numbers, i, i + 1);
                    swapped = true;
                }
            }
        }while (swapped);
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
