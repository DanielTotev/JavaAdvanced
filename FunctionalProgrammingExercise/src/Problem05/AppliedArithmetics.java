package Problem05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class AppliedArithmetics {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String command = reader.readLine();
        Consumer<int[]> add = x -> {
            for (int i = 0; i < x.length ; i++) {
                x[i] += 1;
            }
        };
        Consumer<int[]> multiply = x -> {
            for (int i = 0; i < x.length ; i++)
                x[i] *= 2;

        };
        Consumer<int[]> subtract = x -> {
            for (int i = 0; i < x.length ; i++) {
                x[i] -= 1;
            }
        };
        Consumer<int[]> print = x -> {
            for (int i = 0; i < x.length ; i++) {
                System.out.print(x[i] + " ");
            }
        };
        while (!command.equals("end")){
            if (command.equals("add")){
                add.accept(numbers);
            }else if (command.equals("subtract")){
                subtract.accept(numbers);
            }else if (command.equals("multiply")){
                multiply.accept(numbers);
            }else {
                print.accept(numbers);
            }
            command = reader.readLine();
        }
    }
}
