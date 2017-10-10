package Problem02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumBigNumbers {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder firstNumber = new StringBuilder(reader.readLine());
        StringBuilder secondNumber = new StringBuilder(reader.readLine());
        while (firstNumber.toString().startsWith("0")){
            firstNumber.deleteCharAt(0);
        }
        while (secondNumber.toString().startsWith("0")){
            secondNumber.deleteCharAt(0);
        }
        if (firstNumber.length() > secondNumber.length()){
            int diff = firstNumber.length() - secondNumber.length();
            for (int i = 0; i < diff; i++) {
                secondNumber.insert(0, '0');
            }
        }else if (firstNumber.length() < secondNumber.length()){
            int diff = secondNumber.length() - firstNumber.length();
            for (int i = 0; i < diff; i++) {
                firstNumber.insert(0, '0');
            }
        }
        StringBuilder result = new StringBuilder();
        int remainder = 0;
        for (int i = firstNumber.length() - 1; i >= 0; i--) {
            int currentSum = Integer.parseInt(String.valueOf(firstNumber.charAt(i))) +
                    Integer.parseInt(String.valueOf(secondNumber.charAt(i))) + remainder;
            if (currentSum >= 10){
                result.append(currentSum % 10);
                remainder = currentSum / 10;
            }else {
                result.append(currentSum);
                remainder = 0;
            }
        }
        if (remainder > 0)
            result.append(remainder);

        System.out.println(result.reverse());
    }
}
