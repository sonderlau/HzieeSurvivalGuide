package HDOJ.week7;

import java.util.Scanner;

public class D1279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rounds = sc.nextInt();
        while (rounds -- > 0){
            int num = sc.nextInt();
            int count =0;
            while (num >1){
                if ((num & 1) == 1){
                    if (++count == 1){
                        System.out.print(num);
                    }else {
                        System.out.print(" " + num);
                    }
                    num = num*3 + 1;
                }else {
                    num /= 2;
                }



            }
            if (count == 0){
                System.out.print("No number can be output !");

            }
            System.out.println();
        }
    }
}