package Problem13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;


public class InfernoIII {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        HashMap<String, Predicate<Integer>> commands = new HashMap<>();
        while (true){
            String[] input = reader.readLine().split(";");
            if ("Forge".equals(input[0])){
                break;
            }
            Predicate<Integer> predicate = makePredicate(input[1],Integer.parseInt(input[2]) ,numbers);
            if ("Exclude".equalsIgnoreCase(input[0])){
                commands.put( input[1] + input[2], predicate);
            }else {
                commands.remove( input[1] + input[2]);
            }
        }
        for (int i = 0  ; i < numbers.length; i++) {
            boolean forRemove = false;
            for (Map.Entry<String, Predicate<Integer>> predicateEntry : commands.entrySet()) {
                if (predicateEntry.getValue().test(i)) {
                    forRemove = true;
                    break;
                }
            }
            if (!forRemove)
                System.out.print(numbers[i] + " ");
        }
    }

    private static Predicate<Integer> makePredicate(String condition, Integer targetSum, int[] inputArr) {
        switch (condition){
            case "Sum Left":
                return index -> (index > 0 ? inputArr[index - 1] : 0) + inputArr[index] == targetSum;
            case "Sum Right":
                return index -> (index < inputArr.length-1 ? inputArr[index + 1] : 0) + inputArr[index] == targetSum;
            default:
                return index -> (index > 0 ? inputArr[index - 1] : 0) + inputArr[index] +
                        (index < inputArr.length-1 ? inputArr[index + 1] : 0) == targetSum;
        }
    }
}
