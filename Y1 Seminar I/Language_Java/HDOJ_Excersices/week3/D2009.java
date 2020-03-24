package HDOJ.week3;

import java.util.Scanner;

public class D2009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            double a = sc.nextDouble();
            double start = a;
            int b = sc.nextInt();
            double sum=0;
            for (int much = 1; much < b; much++){

                a = Math.sqrt(a);
                sum += a;
            }
            sum += start;
            String s = String.format("%.2f",sum);;
            System.out.println(s);
        }
        sc.close();
    }
}
