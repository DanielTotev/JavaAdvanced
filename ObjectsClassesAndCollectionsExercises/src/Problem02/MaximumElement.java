package Problem02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumElement {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOFCommands = Integer.parseInt(reader.readLine());
        Deque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < numberOFCommands; i++) {
            int[] commandParams = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (commandParams[0] == 1)
                numbers.push(commandParams[1]);
            else if (commandParams[0] == 2)
                numbers.pop();
            else if (commandParams[0] == 3) {
                Deque<Integer> copyStack = new ArrayDeque<>();
                copyStack.addAll(numbers);
                System.out.println(findMaxNumber(copyStack));
            }
        }
    }
    private static int findMaxNumber(Deque<Integer> numbers){
        int maxNumber = Integer.MIN_VALUE;
        if (numbers.isEmpty())
            return 0;

        while (numbers.size() > 0){
            int number = numbers.pop();
            if (number > maxNumber)
                maxNumber = number;
        }
        return maxNumber;
    }
}
