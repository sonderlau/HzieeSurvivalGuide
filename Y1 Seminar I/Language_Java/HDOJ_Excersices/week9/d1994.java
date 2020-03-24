package HDOJ.week9;

import java.util.Scanner;

public class d1994 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0){
            int y = sc.nextInt();
            int q = sc.nextInt();
            double e = sc.nextDouble();
            double f = sc.nextDouble();
            double g = sc.nextDouble();

            double money = y*(1+e/100.0*q/365.0);
            money = money*(1+g/100.0);
            System.out.printf("%.1f",money);
            System.out.println();
            money = y*(1+f/100.0*(q+365)/365.0);
            System.out.printf("%.1f",money);
            System.out.println();
        }

    }
}
