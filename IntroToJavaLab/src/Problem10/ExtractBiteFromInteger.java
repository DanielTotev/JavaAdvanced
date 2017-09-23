package Problem10;

import java.util.Scanner;

public class ExtractBiteFromInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int position = scanner.nextInt();
        int mask = number >> position;
        int bit = mask & 1;
        System.out.println(bit);
    }
}
