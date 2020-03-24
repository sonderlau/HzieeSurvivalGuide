package HDOJ.week5;

import java.math.BigInteger;
import java.util.Scanner;

public class D1013 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            BigInteger b = scanner.nextBigInteger();
            if (b.intValue() == 0) {
                break;
            } else if (b.mod(new BigInteger(String.valueOf(9))).intValue() == 0) {
                System.out.println(9);
            } else {
                System.out.println(b.mod(new BigInteger(String.valueOf(9))));
            }

        }
    }
}
