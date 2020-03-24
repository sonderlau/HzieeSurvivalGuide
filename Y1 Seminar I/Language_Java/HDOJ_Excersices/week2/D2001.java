package HDOJ.week2;

import java.util.Scanner;

public class D2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextDouble()){
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();

            double distance = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));

            String result = String.format("%.2f",distance);

            System.out.println(result);

        }
        sc.close();
    }
}
