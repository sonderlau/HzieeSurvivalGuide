package HDOJ.week9;

import java.util.Scanner;

public class d1570 {
    static int t, n, m;
    static String c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            c = sc.next();
            n = sc.nextInt();
            m = sc.nextInt();
            if (c.equals("A")) {
                System.out.println(A(n, m));
            } else {
                System.out.println(C(n, m));
            }
        }
    }
    static int A(int n, int m) {
        int ans = 1;
        for (int i = n; i >= n - m + 1; i--) {
            ans = ans * i;
        }
        return ans;
    }
    static int C(int n , int m) {
        return A(n, m) / A(m, m);
    }
}
