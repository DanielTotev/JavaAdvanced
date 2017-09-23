package Problem04;

import java.math.BigDecimal;
import java.util.Scanner;

public class EuroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal result = new BigDecimal("4210500000000");
        double quantity = Double.valueOf(scanner.nextLine());
        double priceInLeva = quantity * 1.20;
        result = result.multiply(new BigDecimal(priceInLeva));
        System.out.printf("%.2f marks" + System.lineSeparator(), result);
    }
}
