package HDOJ.week2;

import java.util.Scanner;

public class D2002 {
    public static void main(String[] args) {
        final double PI = 3.1415927;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextDouble()){
            double r = sc.nextDouble();
            double result = 4*PI*r*r*r/3;
            String s = String.format("%.3f",result);
            System.out.println(s);
        }
        sc.close();
    }
}
