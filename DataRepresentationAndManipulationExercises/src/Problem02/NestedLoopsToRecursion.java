package Problem02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NestedLoopsToRecursion {
    public static int numberOfLoops;
    public static int[] loops;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numberOfLoops = Integer.parseInt(reader.readLine());
        loops = new int[numberOfLoops];
        simulateLoops(0);
    }
    private static void simulateLoops(int current){
        if (current == numberOfLoops){
            printLoop();
            return;
        }

        for (int i = 1; i <= numberOfLoops; i++) {
            loops[current] = i;
            simulateLoops(current + 1);
        }
    }

    private static void printLoop() {
        System.out.println(Arrays.toString(loops).replace("[", "")
        .replace("]", "")
        .replace(",", ""));
    }
}
