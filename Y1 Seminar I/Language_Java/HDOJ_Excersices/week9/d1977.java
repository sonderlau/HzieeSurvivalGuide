package HDOJ.week9;

import java.util.Scanner;

public class d1977 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            long n = sc.nextLong();
            System.out.println(n*n*n+" "+(n+1)*(n+1)*(n+1));
        }
        sc.close();
    }
}
