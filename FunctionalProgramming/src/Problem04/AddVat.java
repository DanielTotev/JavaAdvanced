package Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class AddVat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        UnaryOperator<Double> addVat = number -> number * 1.2;
        double[] numbers = Arrays.stream(reader.readLine().
                split("[, ]+")).
                mapToDouble(Double::parseDouble).
                toArray();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = addVat.apply(numbers[i]);
        }
        System.out.println("Prices with VAT:");
        for (double number : numbers) {
            String formattedNumber = String.format("%.2f", number).replace(".", ",");
            System.out.println(formattedNumber);
        }
    }
}
