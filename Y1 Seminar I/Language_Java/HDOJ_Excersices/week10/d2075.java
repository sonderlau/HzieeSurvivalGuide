package HDOJ.week10;

import java.util.Scanner;

public class d2075 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- != 0) {
            int A = scanner.nextInt(), B = scanner.nextInt();
            System.out.println(A % B == 0 ? "YES" : "NO");
        }
    }
}
