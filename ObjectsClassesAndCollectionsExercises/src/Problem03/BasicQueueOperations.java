package Problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BasicQueueOperations {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] params = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> numberQueue = new ArrayDeque<>();
        for (int i = 0; i < params[0]; i++) {
            numberQueue.offer(numbers[i]);
        }
        for (int i = 0; i < params[1]; i++) {
            numberQueue.poll();
        }
        if (numberQueue.contains(params[2]))
            System.out.println(true);
        else
            System.out.println(findSmallestElement(numberQueue));
    }
    private static int findSmallestElement(Deque<Integer> queue){
        int minNumber = Integer.MAX_VALUE;
        if (queue.isEmpty()){
            return 0;
        }
        while (!queue.isEmpty()){
            int number = queue.poll();
            if (minNumber > number)
                minNumber = number;
        }
        return minNumber;
    }
}
