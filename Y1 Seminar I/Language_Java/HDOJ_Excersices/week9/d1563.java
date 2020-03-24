package HDOJ.week9;

import java.util.Scanner;

public class d1563 {
    private static int n, a;
    private static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            n = sc.nextInt();
            if (n == 0) return;
            ans = 0;
            for (int i = 0; i < n; i++) {
                a = sc.nextInt();
                ans ^= a;
            }
            System.out.println(ans);
        }
    }
}
