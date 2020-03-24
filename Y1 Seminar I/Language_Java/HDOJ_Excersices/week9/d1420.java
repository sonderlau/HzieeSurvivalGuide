package HDOJ.week9;

import java.util.Scanner;

public class d1420 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-->0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            long t = 1;
            while (b-->0) {
                t = (t*a)%c;
            }
            System.out.println(t);
        }
        sc.close();
    }
}
