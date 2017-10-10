import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(numbers);
        int number = Integer.valueOf(reader.readLine());
        int index = binarySearch(numbers, number, 0, numbers.length - 1);
        System.out.println(index);
    }
    private static int binarySearch(int[] arr, int number, int start, int end){
        while (end >= start) {
            int mid = (start + end) / 2;
            if (arr[mid] > number)
                end = mid - 1;
            else if (arr[mid] < number)
                start = mid + 1;
            else
                return mid;
        }

        return -1;
    }
}
