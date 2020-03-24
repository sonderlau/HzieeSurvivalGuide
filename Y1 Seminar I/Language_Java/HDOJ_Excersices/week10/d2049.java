package HDOJ.week10;

import java.util.Scanner;

public class d2049 {
    public static void main(String[] args) {
        long[] a = new long[21];
        a[0]=0;
        a[1]=0;
        a[2]=1;
        for(int i=3;i<21;i++){
            a[i] = (i-1)*(a[i-1]+a[i-2]);
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int max = (n-m)>m?(n-m):m;
            int min = (n-m)<m?(n-m):m;

            long x =  key(n,max,min);

            System.out.println(x*a[m]);

        }


    }

    private static long key(int n, int max, int min) {
        long x=1;
        for(int i=max+1;i<=n;i++){
            x=x*i;
        }
        for(int j=1;j<=min;j++){
            x=x/j;
        }
        return x;
    }
}
