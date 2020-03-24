package HDOJ.week3;

import java.util.Scanner;

public class D2003 {
    public static void main(String[] args) {
        double temp1 = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextDouble()){
            double temp = sc.nextDouble();

            if (temp < 0){
                temp1 = -temp;
            }else {
                temp1 = temp;
                }
            String s = String.format("%.2f",temp1);
            System.out.println(s);
            }
            sc.close();
        }
    }

