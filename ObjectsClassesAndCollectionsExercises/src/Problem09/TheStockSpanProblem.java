package Problem09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class TheStockSpanProblem {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfDays = Integer.parseInt(reader.readLine());
        int[] prices = new int[numberOfDays];
        for (int i = 0; i < numberOfDays; i++) {
            prices[i] = Integer.parseInt(reader.readLine());
        }
        StringBuilder output =new StringBuilder(prices.length);
        //ArrayDeque<Integer> spans = new ArrayDeque<>();
        output.append(1);
        output.append(System.lineSeparator());
        for (int i = 1; i < prices.length; i++) {
            int currentSpan = calculateSpan(prices, i);
            output.append(currentSpan);
            output.append(System.lineSeparator());
        }
        System.out.println(output.toString().trim());
    }
    private static int calculateSpan(int[] prices, int index){
        int counter = 1;
        int currentIndex= index - 1;
        while (currentIndex >= 0 && prices[currentIndex] <= prices[index]){
            counter++;
            currentIndex--;
        }
        return counter;
    }
}
