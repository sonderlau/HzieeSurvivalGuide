package HDOJ.week9;

import java.util.Scanner;

public class d2020 {
    public static void main(String[] args) {
        int[] a = new int[105];
        int n;
        Scanner inScanner = new Scanner(System.in);
        while (inScanner.hasNextInt()) {
            n = inScanner.nextInt();
            if (n == 0)
                break;
            for (int i = 0; i < n; i++)
                a[i] = inScanner.nextInt();
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    int temp;
                    if (Math.abs(a[j]) < Math.abs(a[j + 1])) {
                        temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                    }
                }
            }
            for (int i = 0; i < n - 1; i++)
                System.out.print(a[i] + " ");
            System.out.println(a[n - 1]);
        }
    }
}
