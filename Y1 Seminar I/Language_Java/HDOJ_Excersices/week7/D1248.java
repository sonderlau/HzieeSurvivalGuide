package HDOJ.week7;

import java.util.Scanner;

public class D1248 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            while(n-->0) {
                int m = sc.nextInt();
                int[] a = { 150, 200, 350 };
                int[] b = new int[10005];
                for(int i=0;i<a.length;i++) {
                    for(int j=a[i];j<=m;j++) {
                        b[j]=Math.max(b[j], b[j-a[i]]+a[i]);
                    }
                }
                System.out.println(m - b[m]);
            }
        }
    }
}
