package Problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] stackParams = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> numberStack = new ArrayDeque<>();
        for (int i = 0; i < stackParams[0]; i++) {
            numberStack.push(numbers[i]);
        }

        for (int i = 0; i < stackParams[1]; i++) {
            numberStack.pop();
        }

        if (numberStack.contains(stackParams[2]))
            System.out.println(true);
        else
            System.out.println(findSmallestElement(numberStack));
    }
    private static int findSmallestElement(Deque<Integer> stack){
        int minNumber = Integer.MAX_VALUE;
        if (stack.isEmpty()){
            return 0;
        }
        while (!stack.isEmpty()){
            int number = stack.pop();
            if (minNumber > number)
                minNumber = number;
        }
        return minNumber;
    }
}
