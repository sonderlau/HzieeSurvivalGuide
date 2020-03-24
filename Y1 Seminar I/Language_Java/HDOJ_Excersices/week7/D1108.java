package HDOJ.week7;

import java.util.Scanner;

public class D1108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int gcd = 0;
            if (num1 > num2){
                gcd = gcd(num1,num2);
            }else {
                gcd = gcd(num2,num1);
            }
            System.out.println(num1*num2/gcd);
        }
        sc.close();
    }
    private static int gcd(int num1, int num2){
        return (num2 == 0)? num1 : gcd(num2,num1%num2);
    }
}
