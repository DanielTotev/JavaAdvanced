package Problem08;

import java.math.BigInteger;
import java.util.Scanner;

public class ProductOfNumbersFromNToM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        BigInteger product = new BigInteger("1");
        for (int i = start; i <= end; i++) {
            product = product.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.printf("product[%d..%d] = %d", start, end, product);
    }
}
