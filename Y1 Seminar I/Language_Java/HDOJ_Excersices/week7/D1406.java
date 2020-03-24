package HDOJ.week7;

import java.util.Scanner;

public class D1406 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rounds = sc.nextInt();
        for (int i = 0; i < rounds; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int max=0,min=0;
            if (num1 > num2){
                max = num1;
                min = num2;
            }else {
                max = num2;
                min = num1;
            }
            int count=0;
            for (int j = min; j <= max ; j++) {
                if (judge(j)){
                    count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
    public static boolean judge(int num){
        int result =0;
        for (int i = 1; i <= num/2 ; i++) {
            if (num % i ==0){
                result += i;
            }

        }
        return num == result;
    }
}
