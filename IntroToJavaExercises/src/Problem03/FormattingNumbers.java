package Problem03;

import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String aToHex = Integer.toHexString(a).toUpperCase();
        String aToBinary = Integer.toBinaryString(a);
        StringBuilder binaryWithLeadingZeroes = new StringBuilder();
        if (aToBinary.length() < 10){
            for (int i = 0; i < 10 - aToBinary.length(); i++) {
                binaryWithLeadingZeroes.append("0");
            }
        }
        binaryWithLeadingZeroes.append(aToBinary);
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        String result = String.format("|%-10s|%s|%10.2f|%-10.3f|", aToHex, binaryWithLeadingZeroes.toString(), b, c);
        System.out.println(result);
    }
}
