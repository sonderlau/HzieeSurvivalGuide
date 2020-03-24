package HDOJ.week4;

import java.util.Scanner;

public class D2039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rounds = sc.nextInt();
        for (int i = 0; i < rounds; i++) {
            double a =sc.nextDouble();
            double b =sc.nextDouble();
            double c =sc.nextDouble();

            if (a+b > c && a+c > b && b+c>a ){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
