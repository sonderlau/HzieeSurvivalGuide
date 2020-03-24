package HDOJ.week3;

import java.util.Scanner;

public class D2007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){

            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a > b){
                int temp = b;
                b = a;
                a =temp;
            }

            int sum1= 0,sum2=0;

            for (int i = a;i<=b;i++){
                if ((i & 1 ) == 0){
                    sum1 += Math.pow(i,2);
                }else {
                    sum2 += Math.pow(i,3);
                }
            }
            System.out.println(sum1 + " " + sum2);
        }
        sc.close();
    }
}
