package Problem11;

import java.util.Scanner;

public class ModifyABit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  number = scanner.nextInt();
        int  position = scanner.nextInt();
        int  bitValue = scanner.nextInt();
        int mask = bitValue == 1 ? 1 << position : ~(1 << position);
        int result = bitValue == 1 ? number | mask : number & mask;
        System.out.println(result);
    }
}
