package HDOJ.week5;

import java.util.Scanner;

public class D1019 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt() - 1;
            int sum = sc.nextInt();
            while (n-- > 0) {
                sum = gcm(sum, sc.nextInt());
            }
            System.out.println(sum);
        }
        sc.close();

    }
    private static int gcm(int a,int b){
        return a / gcd(a, b) * b;

    }
    private static int gcd(int a,int b){
        if (a<b){
            int temp = b;
            b = a;
            a = temp;
        }
        if (b == 0){
            return a;
        }else {
            return gcd(b,a%b);
        }
    }
}
