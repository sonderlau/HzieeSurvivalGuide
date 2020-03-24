package HDOJ.week4;

import java.util.Scanner;

public class D2011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rounds = sc.nextInt();
        for (int i = 0; i < rounds; i++) {
            int start = sc.nextInt();
            String s = String.format("%.2f",getSum(start));
            System.out.println(s);
        }
        sc.close();
    }


    public static double getSum(double num ){
        double result= 0;

        for (int i = 1; i <= num ; i++) {
            result += (1.0/i * Math.pow(-1,i+1));
        }



        return result;
    }
}
